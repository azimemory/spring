package com.kh.toy.common.util.file;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.toy.common.code.Code;

@Entity(name = "file_info")
@DynamicInsert
@DynamicUpdate
public class FileEntity {
	
	@Id
	@GeneratedValue
	private Long flIdx;
	private String originFileName;
	private String renameFileName;
	private String savePath;
	private String isDel;
	Date regDate;

	public Long getFlIdx() {
		return flIdx;
	}

	public void setFlIdx(Long flIdx) {
		this.flIdx = flIdx;
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
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getFullPath() {
		return Code.UPLOAD+savePath;
	}
	
}
