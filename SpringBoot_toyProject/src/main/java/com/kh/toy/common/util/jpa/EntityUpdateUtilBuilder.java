package com.kh.toy.common.util.jpa;

public class EntityUpdateUtilBuilder<T> {
	protected T entity;
	protected T vo;
	
	public EntityUpdateUtilBuilder<T> entity(T entity) {
		this.entity = entity;
		return this;
	}
	
	public EntityUpdateUtilBuilder<T> vo(T vo) {
		this.vo = vo;
		return this;
	}
	
	public EntityUpdateUtil<T> build(){
		return new EntityUpdateUtil<T>(this);
	}
}
