package com.kh.spring.batch;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchRepository {
	
	@Insert("insert into baseball_rank(rank,name,game,win,lose,tie,reg_date)"
			+ " values(#{rank},#{name},#{game},#{win},#{lose},#{tie},sysdate)")
	void insertBaseBallRank(Map<String,String> commandMap);

}
