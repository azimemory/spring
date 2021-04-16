package com.kh.toy.common.util.jpa;

import java.util.ArrayList;
import java.util.List;

public class MergeEntityBuilder<T> {
	protected T entity;
	protected T vo;
	protected boolean ignoreJVMDeafultSetting = true;
	protected List<String> ignoreProperties = new ArrayList<String>();
	
	public MergeEntityBuilder<T> entity(T entity) {
		this.entity = entity;
		return this;
	}
	
	public MergeEntityBuilder<T> vo(T vo) {
		this.vo = vo;
		return this;
	}
	
	public MergeEntityBuilder<T> ignoreJVMDeafultSetting(boolean flg) {
		this.ignoreJVMDeafultSetting = flg;
		return this;
	}
	
	public MergeEntityBuilder<T> ignoreProperties(String properties) {
		this.ignoreProperties.add(properties);
		return this;
	}
	
	public MergeEntity<T> build(){
		return new MergeEntity<T>(this);
	}
}
