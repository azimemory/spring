package com.kh.toy.common.util.jpa;

import java.lang.reflect.Field;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

public class EntityUpdateUtil<T> {
	
	private T entity;
	private T vo;
	
	protected EntityUpdateUtil(EntityUpdateUtilBuilder<T> builder){
		this.entity = builder.entity;
		this.vo = builder.vo;
		
		try {
			//entity와 vo의 필드를 필드배열에 저장
			Field[] entityFields  = entity.getClass().getFields();
			Field[] voFields = vo.getClass().getFields();
		
			for (int i = 0; i < entityFields.length; i++){
				//entity와 vo의 필드가 같다면 continue
				if(entityFields[i].equals(voFields[i])) {
					System.out.println("다 같다고?");
					continue;
				}else {//entity와 vo의 필드가 다르면 entity의 필드에 vo필드의 값을 담아준다.
					entityFields[i].set(entity, voFields[i].get(voFields[i].getClass()));
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e){
			throw new ToAlertException(ErrorCode.CODE_500,e);
		}
	}
	
	public T get() {
		return entity;
	}
}
