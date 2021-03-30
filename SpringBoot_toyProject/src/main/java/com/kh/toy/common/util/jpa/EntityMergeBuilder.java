package com.kh.toy.common.util.jpa;

public class EntityMergeBuilder<T> {
	protected T entity;
	protected T vo;
	
	public EntityMergeBuilder<T> entity(T entity) {
		this.entity = entity;
		return this;
	}
	
	public EntityMergeBuilder<T> vo(T vo) {
		this.vo = vo;
		return this;
	}
	
	public EntityMerge<T> build(){
		return new EntityMerge<T>(this);
	}
}
