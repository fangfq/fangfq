package net.jqsoft.ssm.domain;

public class User {
	
	/*
	 * 名称
	 */
	private String name;
	/*
	 * 密码
	 */
	private String password;
	/*
	 * 主机地址
	 */
	private String host;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
}
