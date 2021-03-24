package beanTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanTest {
	
	private Code code;
	private Date date;
	
	public BeanTest() {
		System.out.println("빈 등록 테스트 기본 생성자");
	}
	
	//생성자의 매개변수로 객체를 전달 받아보자
	public BeanTest(Date date) {
		System.out.println("매개변수가 있는 생성자 : " + date);
		this.date = date;
	}
	
	public void setCode(Code code) {
		this.code = code;
		System.out.println("setCode : " + code);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber :" + num);
	}
	
	//빈을 생성할 때 배열 전달 받기
	public void setArray(String[] arr) {
		System.out.println("setArray : " + Arrays.toString(arr));
	}
	
	//빈을 생성할 때 리스트 전달 받기
	public void setList(List list) {
		System.out.println("setList : " + list);
	}
	
	//빈을 생성할 때 set 전달 받기
	public void setSet(Set set) {
		System.out.println("setSet : " + set);
	}
	
	//빈을 생성할 때 map 전달 받기
	public void setMap(Map map) {
		System.out.println("setMap : " + map);
	}
	
	//빈을 생성할 때 properties 전달 받기
	public void setProperties(Properties props) {
		System.out.println("setProperties : " + props);
	}
	
	
	//빈을 생성할 때 ScoreList 전달 받기
	public void setScoreList(List<Score> scoreList) {
		System.out.println("setScoreList :  " + scoreList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
