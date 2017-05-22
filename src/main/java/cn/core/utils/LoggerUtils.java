package cn.core.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 功能:类主要功能 - 日志输出类<br>
 * 作者: Administrator <br>
 * 时间:2015年12月29日 上午9:49:33 <br> <br>
 */
public class LoggerUtils {
	private static String start = "-----------------------------start-----------------------------------------\n";
	private static String numberData = "[info-]Line Number: {} ,Time: {}\n[data-]{}";
	private static String end = "\n[:::: ]--------------------------------end-----------------------------------------\n";
	private static String infoNumber = start+numberData+end;
	private static String infoNotNumber = "print data :{}";
	private LoggerUtils(){
	}
	private static Logger log(Class<?> clz) {
		return LoggerFactory.getLogger(clz);
	}
	
	/**
	 * 日志输出,级别:info
	 * @param clz 类
	 * @param num 行号
	 * @param obj 打印对象
	 */
	public static void info(Class<?> clz,Integer num,Object obj) {
		Logger log = log(clz);
		String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		log.info(infoNumber, new Object[]{num, time,obj});
	}
	/**
	 * 
	 * 功能: - 日志输出,级别:info<br>
	 * 作者: Administrator <br>
	 * 时间:2016年11月4日 上午11:23:43 <br>
	 * ::
	 * @param clz 类
	 * @param obj 打印对象
	 * void
	 */
	public static void info(Class<?> clz,Object obj) {
		Logger log = log(clz);
		log.info(infoNotNumber, obj);
	}
	/**
	 * 日志输出,级别:debug
	 * @param clz 类
	 * @param num 行号
	 * @param obj 打印对象
	 */
	public static void debug(Class<?> clz,Integer num,Object obj) {
		Logger log = log(clz);
		String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		log.debug(infoNumber, new Object[]{num, time,obj});
	}
	/**
	 * 功能: - 日志输出,级别:debug<br>
	 * 作者: Administrator <br>
	 * 时间:2016年11月4日 上午11:24:17 <br>
	 * ::
	 * @param clz 类
	 * @param obj 打印对象
	 * void
	 */
	public static void debug(Class<?> clz,Object obj) {
		Logger log = log(clz);
		log.debug(infoNotNumber, obj);
	}
	/**
	 * 日志输出,级别:error
	 * @param clz 类
	 * @param num 行号
	 * @param obj 打印对象
	 */
	public static void error(Class<?> clz,Integer num,Object obj) {
		Logger log = log(clz);
		String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		log.error(infoNumber, new Object[]{num, time,obj});
	}
	/**
	 * 
	 * 功能: - 日志输出,级别:error<br>
	 * 作者: Administrator <br>
	 * 时间:2016年11月4日 上午11:24:47 <br>
	 * ::
	 * @param clz 类
	 * @param obj 打印对象
	 * void
	 */
	public static void error(Class<?> clz,Object obj) {
		Logger log = log(clz);
		log.error(infoNotNumber, obj);
	}
	
}
