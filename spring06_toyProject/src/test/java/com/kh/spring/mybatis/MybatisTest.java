package com.kh.spring.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MybatisTest {
	
	//SqlSessionTemplate 주요 메서드
	//selectOne : 단일행을 반환하는 select문 실행 메서드
	//selectList : 다중 행을 반환하는 select문 실행 메서드
	//insert : 메서드의 결과값은 쿼리에 의해 영향을 받은 row 수 
	//update : 메서드의 결과값은 쿼리에 의해 영향을 받은 row 수 
	//delete : 메서드의 결과값은 쿼리에 의해 영향을 받은 row 수 
	//** procedure 호출은 dml쿼리 메서드 중 선택

	@Autowired
	private MybatisRepository mybatisRepository;
	String userId = "dev";
	
	@Test
	public void selectOneTest() {
		mybatisRepository.selectPasswordByUserId(userId);
	}
	
	@Test
	public void selectOneAsDTO() {
		mybatisRepository.selectMemberById(userId);
	}
	
	@Test
	public void selectListAsMap() {
		mybatisRepository.selectRentAndMemberById(userId);
	}
	
	@Test
	public void selectListUsingResultMap() {
		mybatisRepository.selectRentDataByUserId(userId);
	}
	
	@Test
	public void insertWithDto() {
		Member member = new Member();
		member.setUserId("mybatis-interface");
		member.setPassword("asdhakjwhek");
		member.setEmail("ppp@ccc.com");
		member.setTell("016-894-8248");
		
		mybatisRepository.insertWithDto(member);
	}
	
	@Test
	public void insertWithMap() {
		Member member = new Member();
		member.setUserId("mybatis-interface");
		mybatisRepository.insertWithMap(Map.of("member", member, "title", "SpringMVC가자아 외 1권", "rentBookCnt", 2));
	}
	
	@Test
	public void delete() {
		mybatisRepository.delete("mybatis-interface");
	}	
	
	@Test
	public void update() {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("mnbvc");
		mybatisRepository.update(member);
	}
	
	@Test
	public void procedure() {
		mybatisRepository.procedure("100004");
	}
	

	
   @Test
   public void dynamicQueryIF() {
	   mybatisRepository.dynamicQueryIf(Map.of("searchType", "author", "keyword", "김애란"));
   }
   
   @Test
   public void dynamicQueryChoose() {
	   mybatisRepository.dynamicQueryChoose(Map.of("searchType", "author", "keyword", "김애란"));
   }

   @Test
   public void dynamicQueryWhereAndForeachTag() {
	   String[] searchTypes = {"title","author"};
	   mybatisRepository.dynamicQueryWhereAndForeachTag(Map.of("searchTypes",searchTypes,"keyword","김애란"));
   }
   
   @Test
   public void dynamicQueryForeachTagWithList() {
	   mybatisRepository.dynamicQueryForeachTagWithList(List.of("DEV", "mybatis", "pclass"));
   }
   
   @Test
   public void dynamicQuerySetTag() {
	   Member member = new Member();
	   member.setUserId("DEV");
	   member.setPassword("00009999");
	   mybatisRepository.dynamicQuerySetTag(member);
   }
   
   @Test
   public void dynamicQueryForeachTag() {
	   
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//1. 도서명 : 쿠키와 세션, 
	//	 작가   : 김영아
	//	 도서번호 : 시퀀스 사용
	//   인 도서를 BOOK 테이블에 저장하기
	//   메서드 이름 : test01
	@Test
	public void test01() {}
		
	//2. 연장횟수가 2회 이상인 모든 대출도서 정보를
	//	 연장횟수 0회로 초기화 해주세요.
	//  메서드 이름 : test02
	@Test
	public void test02() {}
	
	//3. 2021년 9월 이전에 가입된 회원정보를 삭제
	//  메서드 이름 : test03
	@Test
	public void test03() {}
		
	//4. 대출 횟수가 가장 많은 3권의 도서를 조회
	//  메서드 이름 : test04
	@Test
	public void test04() {}
	
	
	
	
	
}
