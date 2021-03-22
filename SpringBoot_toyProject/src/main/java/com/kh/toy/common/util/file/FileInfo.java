package com.kh.toy.common.util.file;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.toy.common.code.Code;

@Entity
@DynamicInsert
@DynamicUpdate
public class FileInfo {
	
	@Id
	String flIdx;
	String typeIdx;
	String originFileName;
	String renameFileName;
	String savePath;
	String isDel;
	Date regDAte;
	
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
	
	public String getIsDel() {
		return isDel;
	}
	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Date getRegDAte() {
		return regDAte;
	}
	public void setRegDAte(Date regDAte) {
		this.regDAte = regDAte;
	}
	
	public String getFullPath() {
		return Code.UPLOAD+savePath;
	}
	
}
