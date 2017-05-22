package cn.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

/**
 * 字符串的帮助类，提供静态方法，不可以实例化。
 * 
 */
public class StringUtil {
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
	private static byte[] publicKey = { 17, 16, 34, 33, 51, 49, 68, 65, 85, 81 };
	private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };
	private static int CHUNK_SIZE = 10485760;

	/**
	 * 禁止实例化
	 */
	private StringUtil() {
	}
	/**
	 * 
	 * 功能: - 读取流到string<br>
	 * 作者: Administrator<br>
	 * 时间:2016年12月1日 上午9:55:37 <br>
	 * ::
	 * @param inputStream
	 * @return
	 * String
	 */
	public static String getBodyString(InputStream inputStream) {
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();

	}
	/**
	 * 处理url
	 * 
	 * url为null返回null，url为空串或以http://或https://开头，则加上http://，其他情况返回原参数。
	 * 
	 * @param url
	 * @return
	 */
	public static String handelUrl(String url) {
		if (url == null) {
			return null;
		}
		url = url.trim();
		if (url.equals("") || url.startsWith("http://") || url.startsWith("https://")) {
			return url;
		} else {
			return "http://" + url.trim();
		}
	}

	/**
	 * 分割并且去除空格
	 * 
	 * @param str
	 *            待分割字符串
	 * @param sep
	 *            分割符
	 * @param sep2
	 *            第二个分隔符
	 * @return 如果str为空，则返回null。
	 */
	public static String[] splitAndTrim(String str, String sep, String sep2) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		if (!StringUtils.isBlank(sep2)) {
			str = StringUtils.replace(str, sep2, sep);
		}
		String[] arr = StringUtils.split(str, sep);
		// trim
		for (int i = 0, len = arr.length; i < len; i++) {
			arr[i] = arr[i].trim();
		}
		return arr;
	}

	/**
	 * 文本转html
	 * 
	 * @param txt
	 * @return
	 */
	public static String txt2htm(String txt) {
		if (StringUtils.isBlank(txt)) {
			return txt;
		}
		StringBuilder sb = new StringBuilder((int) (txt.length() * 1.2));
		char c;
		boolean doub = false;
		for (int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			if (c == ' ') {
				if (doub) {
					sb.append(' ');
					doub = false;
				} else {
					sb.append("&nbsp;");
					doub = true;
				}
			} else {
				doub = false;
				switch (c) {
				case '&':
					sb.append("&amp;");
					break;
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '"':
					sb.append("&quot;");
					break;
				case '\n':
					sb.append("<br/>");
					break;
				default:
					sb.append(c);
					break;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 剪切文本。如果进行了剪切，则在文本后加上"..."
	 * 
	 * @param s
	 *            剪切对象。
	 * @param len
	 *            编码小于256的作为一个字符，大于256的作为两个字符。
	 * @return
	 */
	public static String textCut(String s, int len, String append) {
		if (s == null) {
			return null;
		}
		int slen = s.length();
		if (slen <= len) {
			return s;
		}
		// 最大计数（如果全是英文）
		int maxCount = len * 2;
		int count = 0;
		int i = 0;
		for (; count < maxCount && i < slen; i++) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		if (i < slen) {
			if (count > maxCount) {
				i--;
			}
			if (!StringUtils.isBlank(append)) {
				if (s.codePointAt(i - 1) < 256) {
					i -= 2;
				} else {
					i--;
				}
				return s.substring(0, i) + append;
			} else {
				return s.substring(0, i);
			}
		} else {
			return s;
		}
	}

	public static String htmlCut(String s, int len, String append) {
		String text = html2Text(s, len * 2);
		return textCut(text, len, append);
	}

	public static String html2Text(String html, int len) {
		try {
			Lexer lexer = new Lexer(html);
			Node node;
			StringBuilder sb = new StringBuilder(html.length());
			while ((node = lexer.nextNode()) != null) {
				if (node instanceof TextNode) {
					sb.append(node.toHtml());
				}
				if (sb.length() > len) {
					break;
				}
			}
			return sb.toString();
		} catch (ParserException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param keyword
	 *            源词汇
	 * @param smart
	 *            是否智能分词
	 * @return 分词词组(,拼接)
	 */
	/*
	 * public static String getKeywords(String keyword, boolean smart) {
	 * StringReader reader = new StringReader(keyword); IKSegmenter iks = new
	 * IKSegmenter(reader, smart); StringBuilder buffer = new StringBuilder();
	 * try { Lexeme lexeme; while ((lexeme = iks.next()) != null) {
	 * buffer.append(lexeme.getLexemeText()).append(','); } } catch (IOException
	 * e) { } // 去除最后一个, if (buffer.length() > 0) {
	 * buffer.setLength(buffer.length() - 1); } return buffer.toString(); }
	 */

	/**
	 * p换行
	 * 
	 * @param inputString
	 * @return
	 */
	public static String removeHtmlTagP(String inputString) {
		if (inputString == null)
			return null;
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;
		try {
			// 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			// 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			htmlStr.replace("</p>", "\n");
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textStr;// 返回文本字符串
	}

	public static String removeHtmlTag(String inputString) {
		if (inputString == null)
			return null;
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;
		try {
			// 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			// 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textStr;// 返回文本字符串
	}

	/**
	 * 检查字符串中是否包含被搜索的字符串。被搜索的字符串可以使用通配符'*'。
	 * 
	 * @param str
	 * @param search
	 * @return
	 */
	public static boolean contains(String str, String search) {
		if (StringUtils.isBlank(str) || StringUtils.isBlank(search)) {
			return false;
		}
		String reg = StringUtils.replace(search, "*", ".*");
		Pattern p = Pattern.compile(reg);
		return p.matcher(str).matches();
	}

	public static boolean containsKeyString(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		if (str.contains("'") || str.contains("\"") || str.contains("\r") || str.contains("\n") || str.contains("\t")
				|| str.contains("\b") || str.contains("\f")) {
			return true;
		}
		return false;
	}

	public static String addCharForString(String str, int strLength, char c, int position) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				if (position == 1) {
					// 右補充字符c
					sb.append(c).append(str);
				} else {
					// 左補充字符c
					sb.append(str).append(c);
				}
				str = sb.toString();
				strLen = str.length();
			}
		}
		return str;
	}

	// 将""和'转义
	public static String replaceKeyString(String str) {
		if (containsKeyString(str)) {
			return str.replace("'", "\\'").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n")
					.replace("\t", "\\t").replace("\b", "\\b").replace("\f", "\\f");
		} else {
			return str;
		}
	}

	// 单引号转化成双引号
	public static String replaceString(String str) {
		if (containsKeyString(str)) {
			return str.replace("'", "\"").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n")
					.replace("\t", "\\t").replace("\b", "\\b").replace("\f", "\\f");
		} else {
			return str;
		}
	}

	public static String getSuffix(String str) {
		int splitIndex = str.lastIndexOf(".");
		return str.substring(splitIndex + 1);
	}

	/**
	 * 字符串截断。编码大于127的字符作为占两个位置，否则占一个位置。
	 * 
	 * @param text
	 * @param length
	 * @param append
	 * @return
	 */
	public static String substring(String text, int length, String append) {
		if (StringUtils.isBlank(text) || text.length() < length) {
			return text;
		}
		int num = 0, i = 0, len = text.length();
		StringBuilder sb = new StringBuilder();
		for (; i < len; i++) {
			char c = text.charAt(i);
			if (c > 127) {
				num += 2;
			} else {
				num++;
			}
			if (num <= length * 2) {
				sb.append(c);
			}
			if (num >= length * 2) {
				break;
			}
		}
		if (i + 1 < len && StringUtils.isNotBlank(append)) {
			if (text.charAt(i) > 127) {
				sb.setLength(sb.length() - 1);
			} else {
				sb.setLength(sb.length() - 2);
			}
			sb.append(append);
		}
		return sb.toString();
	}

	public static String substring(String text, int length) {
		return substring(text, length, null);
	}

	public static String urlEncode(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// never
			throw new RuntimeException(e);
		}

	}

	public static String urlDecode(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// never
			throw new RuntimeException(e);
		}
	}

	public static void replace(StringBuilder sb, String searchString, String replacement) {
		int start = 0;
		int end = sb.indexOf(searchString, start);
		if (end == -1) {
			return;
		}
		int searchLength = searchString.length();
		int replaceLength = replacement.length();
		while (end != -1) {
			sb.replace(end, end + searchLength, replacement);
			start = end + replaceLength;
			end = sb.indexOf(searchString, start);
		}
	}

	/**
	 * 将字符串按行风格，支持windows(\r\n)、linux(\n)和(\r)格式换行。
	 * 
	 * @param s
	 * @return
	 */
	public static String[] splitLines(String s) {
		return StringUtils.split(s, "\r\n");
	}

	/**
	 * 将换行符替换成\n
	 * 
	 * @return
	 */
	public static String replaceNewline(String s) {
		s = StringUtils.replace(s, "\r\n", "\n");
		s = StringUtils.replaceChars(s, '\r', '\n');
		return s;
	}

	/**
	 * 过滤Pattern匹配的字符串，并保留group数据。
	 * 
	 * @param input
	 * @param p
	 * @return
	 */
	public static String filter(String input, Pattern p) {
		Matcher m = p.matcher(input);
		int start = 0, end;
		StringBuilder sb = new StringBuilder();
		while (m.find()) {
			end = m.start();
			sb.append(input.subSequence(start, end));
			for (int i = 1, len = m.groupCount(); i <= len; i++) {
				sb.append(input.subSequence(m.start(i), m.end(i)));
			}
			start = m.end();
		}
		end = input.length();
		sb.append(input.subSequence(start, end));
		return sb.toString();
	}

	public static String getTextFromHtml(String html, int length) {
		if (StringUtils.isBlank(html)) {
			return html;
		}
		if (length <= 0) {
			length = Integer.MAX_VALUE;
		}
		StringBuilder buff = new StringBuilder((int) (html.length() * 0.7));
		Lexer lexer = new Lexer(html);
		Node node;
		try {
			while ((node = lexer.nextNode()) != null && buff.length() < length) {
				if (node instanceof TextNode) {
					buff.append(HtmlUtils.htmlUnescape(node.getText()));
				}
			}
		} catch (ParserException e) {
			logger.error("parse html exception", e);
		}
		if (buff.length() > length) {
			buff.setLength(length);
		}
		return buff.toString();
	}

	public static String getTextFromHtml(String html) {
		return getTextFromHtml(html, Integer.MAX_VALUE);
	}

	public static String getRightNowToString() {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String getRightNowToString(String format) {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

	public static String getFileMd5(File file) throws Exception {
		int len;
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		@SuppressWarnings("resource")
		FileInputStream in = new FileInputStream(file);
		byte[] b = new byte[CHUNK_SIZE];

		while ((len = in.read(b)) != -1)
			messageDigest.update(b, 0, len);

		byte[] v1 = messageDigest.digest();
		String bs = bufferToHex(v1);
		messageDigest.update(bs.getBytes());
		messageDigest.update(publicKey);
		return bufferToHex(messageDigest.digest());
	}

	private static String bufferToHex(byte[] bytes) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte[] bytes, int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; ++l)
			appendHexPari(bytes[l], stringbuffer);

		return stringbuffer.toString();
	}

	private static void appendHexPari(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[((bt & 0xF0) >> 4)];
		char c1 = hexDigits[(bt & 0xF)];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static String asString(Object obj) {
		return ((obj != null) ? obj.toString() : "");
	}

	public static String asStringNull(Object obj) {
		return ((obj != null) ? obj.toString() : null);
	}
	
	// 正则1-255
	private static String INT_1To255 = "([1-9]{1,2}|1\\d|[1-9]0|1\\d\\d|2[0-4]\\d|25[0-5])";
	// 正则0-255
	private static String INT_0To255 = "(0|[1-9]{1,2}|1\\d|[1-9]0|1\\d\\d|2[0-4]\\d|25[0-5])";
	// 正则0-254
	// private static String INT_0To254 =
	// "(0|[1-9]{1,2}|1\\d|1\\d\\d|2[0-4]\\d|25[0-4])";

	public static boolean matches(String exp, String val) {
		Pattern pattern = Pattern.compile(exp);
		return pattern.matcher(val).matches();
	}

	/**
	 * ip输入即时正则验证,ip前部分验证
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isInputVIP4Part(String val) {
		String ipExp = "";
		ipExp += INT_1To255; // ip第一段
		if (matches(ipExp, val)) {
			return true;
		}
		ipExp += "\\."; // ip第一段加.
		if (matches(ipExp, val)) {
			return true;
		}
		ipExp += INT_0To255; // ip第二段
		if (matches(ipExp, val)) {
			return true;
		}
		ipExp += "\\."; // ip第二段加.
		if (matches(ipExp, val)) {
			return true;
		}
		ipExp += INT_0To255; // ip第三段
		if (matches(ipExp, val)) {
			return true;
		}
		ipExp += "\\."; // ip第三段加.
		if (matches(ipExp, val)) {
			return true;
		}
		ipExp += INT_0To255; // ip第四段
		if (matches(ipExp, val)) {
			return true;
		}
		return false;
	}

	/**
	 * ip输入即时正则验证,ip前部分验证
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isVIP4(String val) {
		String ipExp = "";
		ipExp += INT_1To255; // ip第一段
		ipExp += "\\."; // ip第一段加.
		ipExp += INT_0To255; // ip第二段
		ipExp += "\\."; // ip第二段加.
		ipExp += INT_0To255; // ip第三段
		ipExp += "\\."; // ip第三段加.
		ipExp += INT_0To255; // ip第四段
		if (matches(ipExp, val)) {
			return true;
		}
		return false;
	}

	public static boolean isNumber(String val) {
		String exp = "^-?\\d+$";
		if (matches(exp, val)) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		System.out.println(replaceKeyString("&nbsp;\r" + "</p>"));
	}

}
