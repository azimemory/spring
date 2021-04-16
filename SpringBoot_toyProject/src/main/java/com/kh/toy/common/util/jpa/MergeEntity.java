package com.kh.toy.common.util.jpa;

import java.lang.reflect.Field;
import java.util.List;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

public class MergeEntity<T> {
	
	private T entity;
	private T vo;
	private boolean ignoreJVMDeafultSetting;
	private List<String> ignoreProperties;
	
	protected MergeEntity(MergeEntityBuilder<T> builder){
		this.entity = builder.entity;
		this.vo = builder.vo;
		this.ignoreJVMDeafultSetting = builder.ignoreJVMDeafultSetting;
		this.ignoreProperties = builder.ignoreProperties;
		
		try {
			//entity와 vo의 필드를 필드배열에 저장
			Field[] entityFields  = entity.getClass().getDeclaredFields();
			Field[] voFields = vo.getClass().getDeclaredFields();
		
			for (int i = 0; i < entityFields.length; i++){
				//private인 속성에 접근할 수 있도록 설정
				entityFields[i].setAccessible(true);
				voFields[i].setAccessible(true);
				
				if(ignoreJVMDeafultSetting) {
					if(checkPropertiesValueIsJvmDefaultSetting(voFields[i])) {
						continue;
					}
				}
				
				if(ignoreProperties.contains(entityFields[i].getName())) {
					continue;
				}
				
				entityFields[i].set(entity, voFields[i].get(vo));
			}
		} catch (IllegalArgumentException | IllegalAccessException e){
			throw new ToAlertException(ErrorCode.CODE_500,e);
		}
	}
	
	private boolean checkPropertiesValueIsJvmDefaultSetting(Field voField) throws IllegalArgumentException, IllegalAccessException {
		if(voField.get(vo) == null) {
			return true;
		}
		
		if(voField.get(vo).equals(0)) {
			return true;
		}
		
		if(voField.get(vo).equals('\u0000')) {
			return true;
		}
		
		return false;
	}
	
	public T get() {
		return entity;
	}
}
