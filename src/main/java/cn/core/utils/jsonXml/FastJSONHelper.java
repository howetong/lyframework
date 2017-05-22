package cn.core.utils.jsonXml;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
/**
 * 
 * 功能:类主要功能 - JSON工具<br>
 * 作者: Administrator <br>
 * 时间:2016年1月7日 上午10:50:04 <br> <br>
 */
public class FastJSONHelper {
	public static SerializeConfig mapping = new SerializeConfig();
	static {
		if (mapping.get(Date.class) == null) {
			mapping.put(Date.class, new SimpleDateFormatSerializer(
					"yyyy-MM-dd HH:mm:ss"));

		}
	}

	/**
	 * 将java类型的对象转换为JSON格式的字符串
	 * 
	 * @param object
	 *            java类型的对象
	 * @return JSON格式的字符串
	 */
	public static <T> String serialize(T object) {
		return serialize(object, true);
	}

	/**
	 * 将java类型的对象转换为JSON格式的字符串
	 * 
	 * @param object
	 *            java类型的对象
	 * @param fromat
	 *            是否格式化
	 * @return String
	 */
	public static <T> String serialize(T object, boolean fromat) {

		return JSON.toJSONString(object, fromat);
	}

	/**
	 * 
	 * 将java类型的对象转换为JSON格式的字符串,引用对象可转换
	 * @param object java类型的对象
	 * @param dateFromat  时间格式 默认:yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static <T> String serialize(T object, String dateFromat) {
		if (dateFromat == null || "".equals(dateFromat)) {
			dateFromat = "yyyy-MM-dd HH:mm:ss";
		}
		return JSON.toJSONStringWithDateFormat(object, dateFromat,
				SerializerFeature.DisableCircularReferenceDetect);
	}

	/**
	 * 将java类型的对象转换为JSON格式的字符串
	 * 
	 * @param object
	 * @param config
	 * @return String
	 */
	public static <T> String serialize(T object, SerializeConfig config) {
		return JSON.toJSONString(object, config);
	}
	/**
	 * 对象转JSON,仅转指定的对象字段
	 * @param object,对象
	 * @param filter,指定的对象字段
	 * @return JSON
	 */
	public static <T> String Serialize(T object, SimplePropertyPreFilter filter){
		return JSON.toJSONString(object, filter);
	}
	/**
	 * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
	 * 
	 *            JSON格式的字符串
	 * @param json
	 *            java类型或者java数组类型，不包括java集合类型
	 * @param clz
	 * java类型的对象或者java数组类型的对象，不包括java集合类型的对象
	 * @return T 
	 */
	public static <T> T deserialize(String json, Class<T> clz) {
		return JSON.parseObject(json, clz);
	}

	/**
	 * 将JSON格式的字符串转换为List<T>类型的对象
	 * 
	 *            JSON格式的字符串
	 * @param json
	 *            指定泛型集合里面的T类型
	 * @param clz
	 * 类型的对象
	 * @return List<T>
	 */
	public static <T> List<T> deserializeList(String json, Class<T> clz) {
		return JSON.parseArray(json, clz);
	}

	/**
	 * 将JSON格式的字符串转换成任意Java类型的对象
	 * 
	 *            JSON格式的字符串
	 * @param json
	 *            任意Java类型
	 * @param type
	 * 任意Java类型的对象
	 * @return T 
	 */
	public static <T> T deserializeAny(String json, TypeReference<T> type) {
		return JSON.parseObject(json, type);
	}
}