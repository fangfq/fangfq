package net.jqsoft.system.utils;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
		
	/**
	 * 如果字符串为NULL,"" 或 " "返回false
	 * @author fangfq
	 *	@date 2018年4月3日
	 * @param str
	 * @return  boolean
	 */
	public static boolean isNotBlank(String str) {
		return str != null && !"".equals(str) && !" ".equals(str);
	}
	
	
}
