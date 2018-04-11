package net.jqsoft.system.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 日期工具类，多种日期处理工具
 * @author fangfq
 *	@date 2018年4月8日  
 */
public class DateUtils {
	
	private static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * @desc<p>long型日期转换成正常的日期格式</p>
	 * @author fangfq
	 *	@date 2018年4月8日
	 * @param longDate 时间 long型数据
	 * @param formate 日期格式传入null默认为 yyyy-MM-dd
	 * @return  String format为空时候默认返回yyyy-MM-dd
	 */
	public static String  formatLongDate(Long longDate,String format) {
		if (StringUtil.isNotBlank(format))
			sd = new SimpleDateFormat(format);
		Date date = new Date(longDate);
		return sd.format(date);
	}
	
}
