package net.jqsoft.system;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.jqsoft.ssm.domain.FileVo;
import net.jqsoft.ssm.domain.LayuiResponseVo;
import net.jqsoft.ssm.domain.User;
import net.jqsoft.system.utils.DateUtils;
import net.jqsoft.system.utils.FileUtils;
import net.jqsoft.system.utils.PoConstant;
import net.jqsoft.system.utils.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @desc 日志管理Controller
 * @author fangfq
 * @2018年4月2日
 */
@Controller
@RequestMapping("/admin/system")
public class LogController {
	
	private Logger logger = Logger.getLogger(LogController.class);
	/**
	 * 获取配置的日志目录位置
	 */
	@Value("${log4j.appender.file.File}")
	private String location;
	
	@RequestMapping("/logList")
	public String list(Model model,User user){
		
		return "log_list.html";
	}
	
	/**
	 *  异步请求封装日志列表数据
	 * @author fangfq
	 *	@date 2018年4月4日
	 * @return  LayuiResponseVo
	 */
	@ResponseBody
	@RequestMapping("/query")
	public LayuiResponseVo query(Integer curr,Integer nums){
		
		LayuiResponseVo responseVo = new LayuiResponseVo();
		//log4j配置的日志的目录
		String dir = location.substring(0, location.lastIndexOf('/'));
		File logDir = new File(dir);
		
		if (StringUtil.isNotBlank(location) && !logDir.exists()) {
			//设置404状态码
			responseVo.setCode(PoConstant.S_CODE_NOT_FOUND);
			responseVo.setMsg("日志目录不存在");
			return responseVo;
		}
		
		File[] fileList = logDir.listFiles();
		responseVo.setCount(String.valueOf(fileList.length));
		ArrayList<FileVo> logList = new ArrayList<FileVo>();
		
		if (curr == null || nums == null) {
			for (File file : fileList) {
				if (file.isFile()) {
					logList.add(new FileVo(file.getName(), FileUtils.getFileSizeTypeKb(file.length(), FileUtils.FILE_SIZE_TYPE_KB), 
							DateUtils.formatLongDate(file.lastModified(), "yyyy-MM-dd HH:mm")));
				}
			}
		} else {
			int listLength = fileList.length;
			//上坐标和下坐标
			int start = (curr-1)*nums;
			int end = start+nums;
			for (int i = start; i < end && i < listLength ; i++) {
				logList.add(new FileVo(fileList[i].getName(), FileUtils.getFileSizeTypeKb(fileList[i].length(), FileUtils.FILE_SIZE_TYPE_KB), 
						DateUtils.formatLongDate(fileList[i].lastModified(), "yyyy-MM-dd HH:mm")));
			}
		}
		
		responseVo.setData(logList);
		return responseVo;
	}
	
	/**
	 * @desc<p>查看日志内容</p>
	 * @author fangfq
	 *	@date 2018年4月8日
	 * @param model
	 * @param html
	 * @return  String
	 */
	@RequestMapping("/viewLog")
	public String viewLog(Model model,String html){
		
		if (StringUtil.isNotBlank(html)){
			//log4j配置的日志的目录
			String dir = location.substring(0, location.lastIndexOf('/'));
			File logDir = new File(dir);
			File htmlPage = new File(logDir,html);
			try {
				String htmlStr = org.apache.commons.io.FileUtils.readFileToString(htmlPage);
				model.addAttribute("pageContent", htmlStr);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return "log_view.html";
	}
	
	/**
	 * @desc<p>删除日志</p>
	 * @author fangfq
	 *	@date 2018年4月8日
	 * @param names
	 * @return  return_type
	 */
	@RequestMapping("/logDelete")
	@ResponseBody
	public LayuiResponseVo logDelete(String[] names) {
		//log4j配置的日志的目录
		String dir = location.substring(0, location.lastIndexOf('/'));
		LayuiResponseVo vo = new LayuiResponseVo();
		for (String name : names) {
			File logFile = new File(dir, name);
			try {
				logFile.delete();
				vo.setCount(vo.getCount()+1);
			} catch (Exception e) {
				logger.error("文件"+logFile.getName()+"删除失败",e);
				vo.setCode(PoConstant.S_CODE_INTERNAL_SERVER_ERROR);
				vo.setMsg(vo.getMsg()==null?"":vo.getMsg()+","+logFile.getName());
			}
		}
		return vo;
	}
	
}
