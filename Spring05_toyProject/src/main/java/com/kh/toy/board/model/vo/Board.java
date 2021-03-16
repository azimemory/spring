package com.kh.toy.board.model.vo;

import java.sql.Date;

public class Board {
	
	private String bdIdx;
	private String userId;
	private Date regDate;
	private String title;
	private String content;
	private int isDel;
	public String getBdIdx() {
		return bdIdx;
	}
	
	public void setBdIdx(String bdIdx) {
		this.bdIdx = bdIdx;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getIsDel() {
		return isDel;
	}
	
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
	@Override
	public String toString() {
		return "Board [bdIdx=" + bdIdx + ", userId=" + userId + ", regDate=" + regDate + ", title=" + title
				+ ", content=" + content + ", isDel=" + isDel + "]";
	}
	
	

}
