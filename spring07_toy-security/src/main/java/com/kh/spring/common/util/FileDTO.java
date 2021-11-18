package com.kh.spring.common.util;

import java.sql.Date;

import com.kh.spring.common.code.Config;

public class FileDTO {
	
	private String flIdx;
	private String typeIdx;
	private String originFileName;
	private String renameFileName;
	private String savePath;
	private Date regDate;
	private int isDel;
	
	public String getFlIdx() {
		return flIdx;
	}
	
	public void setFlIdx(String flIdx) {
		this.flIdx = flIdx;
	}
	
	public String getTypeIdx() {
		return typeIdx;
	}
	
	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}
	
	public String getOriginFileName() {
		return originFileName;
	}
	
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	
	public String getRenameFileName() {
		return renameFileName;
	}
	
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	
	public String getSavePath() {
		return savePath;
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public int getIsDel() {
		return isDel;
	}
	
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
	public String getLink() {
		return Config.DOMAIN.DESC + "/file/" + savePath + renameFileName;
	}
	
	public String getDownloadPath() {
		return Config.UPLOAD_PATH.DESC + savePath;
	}
	
	@Override
	public String toString() {
		return "FileDTO [flIdx=" + flIdx + ", typeIdx=" + typeIdx + ", originFileName=" + originFileName
				+ ", renameFileName=" + renameFileName + ", savePath=" + savePath + ", regDate=" + regDate + ", isDel="
				+ isDel + "]";
	}
	
	
	

}
