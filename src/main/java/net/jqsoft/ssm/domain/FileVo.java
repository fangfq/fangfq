package net.jqsoft.ssm.domain;

public class FileVo {
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件大小
	 */
	private Long fileSize;
	/**
	 * 创建日期
	 */
	private String createTime;
	/**
	 * 最后一次修改时间
	 */
	private String lastModifyTime;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
	public FileVo() {}
	
	public FileVo(String fileName, Long fileSize, 
			String lastModifyTime) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.lastModifyTime = lastModifyTime;
	}
	
}
