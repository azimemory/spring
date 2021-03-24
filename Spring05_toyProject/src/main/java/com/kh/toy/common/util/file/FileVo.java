package com.kh.toy.common.util.file;

import com.kh.toy.common.code.Code;

public class FileVo {

	int fIdx;
	String typeIdx;
	String originFileName;
	String renameFileName;
	String savePath;
	String isDel;
	String fullPath;
	
	public int getfIdx() {
		return fIdx;
	}
	
	public void setfIdx(int fIdx) {
		this.fIdx = fIdx;
	}
	
	public void setfIdx(String fIdx) {
		this.fIdx = Integer.parseInt(fIdx);
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
	
	public String getFullPath() {
		return Code.UPLOAD.desc+savePath;
	}
	
	public String getIsDel() {
		return isDel;
	}
	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getTypeIdx() {
		return typeIdx;
	}

	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}
	
	

}
