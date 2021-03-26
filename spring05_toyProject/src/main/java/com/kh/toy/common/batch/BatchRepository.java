package com.kh.toy.common.batch;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchRepository {
	
	@Insert("insert into tb_baseball(rank,team_name,match,win,loose,tie,rate)"
			+ " values(#{rank},#{teamName},#{match},#{win},#{loose},#{tie},#{rate})")
	int insertBaseBall(Map<String,String> commandMap);

}
