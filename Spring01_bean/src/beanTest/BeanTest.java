package beanTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanTest {
	private Code code;
	
	public BeanTest() {
		System.out.println("빈 등록 테스트 기본생성자");
	}
	
	public BeanTest(Date date) {
		System.out.println("날짜 생성자 : " + date);
	}
	
	public void setCode(Code code) {
		this.code = code;
		System.out.println("setCode 호출 : " + code);
		code.test();
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber 호출 : " + num);
	}
	
	//빈을 생성할 때 배열을 전달 받기
	public void setArray(String[] arr) {
		System.out.println("setArray 호출  : " + Arrays.toString(arr));
	}
	
	//빈을 생성할 때 List 전달 받기
	public void setList(List list) {
		System.out.println("setList 호출  : " + list);
	}
	
	//빈을 생성할 때 Set 전달 받기
	public void setSet(Set set) {
		System.out.println("setSet 호출  : " + set);
	}
	
	//빈을 생성할 때 Map 전달 받기
	public void setMap(Map map) {
		System.out.println("setMap 호출  : " + map);
	}
	
	//빈을 생성할 때 Properties 전달 받기
	public void setProperties(Properties prop) {
		System.out.println("setProperties 호출  : " + prop);
	}
	
	//빈을 생성할 때 Score빈이 담겨있는 List 전달 받기
	public void setScore(List<Score> scoreList) {
		System.out.println("setScore 호출  : " + scoreList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
