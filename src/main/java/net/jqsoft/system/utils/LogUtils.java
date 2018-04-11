package net.jqsoft.system.utils;

import org.apache.log4j.Logger;
import org.springframework.util.ReflectionUtils;
import sun.reflect.Reflection;

/**
 * @desc 用于记录日志
 * @author fangfq
 *	@date 2018年4月10日  
 */
public class LogUtils {
	
	private static Logger logger = null; 
	
	public static Logger getInstance(){
		System.out.println(Reflection.getCallerClass().getClass().getName());
		//参数1 获取调用者的对象
		 return logger = Logger.getLogger(Reflection.getCallerClass(1).getClass());
	}
}
