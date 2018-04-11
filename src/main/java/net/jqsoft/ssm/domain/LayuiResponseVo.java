package net.jqsoft.ssm.domain;

import java.util.List;

import net.jqsoft.system.utils.PoConstant;

/**
 * @desc layui json响应数据 需要传入的泛型是数据封装的类型
 * @author fangfq
 *	@date 2018年4月4日  
 */
public class LayuiResponseVo {
		
	/**
	 *数据状态,默认为200
	 */
	private String code = PoConstant.S_CODE_SUCCESS ;
	/**
	 * 返回的提示信息，默认为空 
	 */
	private String msg = "";
	/**
	 * 数据总数 默认为0
	 */
	private String count = "0";
	/**
	 * 计数
	 */
	private int num;
	/**
	 * 数据
	 */
	private List data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
