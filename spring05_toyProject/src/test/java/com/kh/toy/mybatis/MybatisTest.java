package com.kh.toy.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.toy.member.model.vo.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MybatisTest {
	
	@Autowired
	MybatisRepository mybatisRepository;
	private String userId = "test";
	
	@Test
	public void selectOneTest() {
		System.out.println(mybatisRepository.selectOne(userId));
	}
	
	@Test
	public void selectListReturnedAsMap() {
		mybatisRepository.selectListReturnedAsMap(userId);
	}
	
	@Test
	public void selectList() {
		mybatisRepository.selectList();
	}
	
	@Test
	public void insertWithVo() {
		Member member = new Member();
		member.setUserId("파파파라안마앗");
		member.setPassword("궁금해 허니이");
		member.setEmail("test@test.com");
		member.setTell("010-0112-1190");
		mybatisRepository.insertWithVo(member);
	}
	
	@Test
	public void insertWithMap() {
		Map<String,Object> commandMap = new HashMap<>();
		Member member = new Member();
		
		member.setUserId(userId);
		commandMap.put("member", member);
		commandMap.put("title", "해리포터와 불사조의 기사단 외 2권");
		commandMap.put("rentBookCnt", 3);
		
		mybatisRepository.insertWithMap(commandMap);
	}
	
	@Test
	public void update() {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("동해물과백두산이");
		mybatisRepository.update(member);
	}
	
	@Test
	public void procedure() {
		String bIdx = "100487";
		insertWithMap();
		mybatisRepository.procedure(bIdx);
	}
	
	@Test
	public void dynamicQueryIF() {
		//사용자가 도서 검색필터에서 info를 선택하고 검색하면 사용자가 입력한 키워드로 info 컬럼을 검색
		//사용자가 도서 검색필터에서 author를 선택하고 검색하면 사용자가 입력한 키워드로 author 컬럼을 검색
		//사용자 선택 필터 : info
		//사용자 입력 키워드 : 도시
		Map<String,Object> commandMap = new HashMap<String, Object>();
		commandMap.put("searchType","info");
		commandMap.put("keyword","도시");
		mybatisRepository.dynamicQueryIF(commandMap);
	}
	
	@Test
	public void dynamicQueryChoose() {
		//사용자가 도서 검색필터에서 info를 선택하고 검색하면 사용자가 입력한 키워드로 info 컬럼을 검색
		//사용자가 도서 검색필터에서 author를 선택하고 검색하면 사용자가 입력한 키워드로 author 컬럼을 검색
		//사용자가 검색필터를 지정 하지 않을 경우 도서 제목으로 검색
		//사용자 선택 필터 : info
		//사용자 입력 키워드 : 도시
		Map<String,Object> commandMap = new HashMap<String, Object>();
		commandMap.put("searchType","title");
		commandMap.put("keyword","도시");
		mybatisRepository.dynamicQueryChoose(commandMap);
	}
	
	@Test
	public void dynamicQuerySetTag() {
		//사용자가 회원수정란에서 수정한 내용을 update하는 쿼리를 작성
		//사용자가 password, email만 수정했다면, update쿼리를
		//[update tb_member set password = 1234, email = 'aa@aa.com' where userId = 'aa']
		
		Member member = new Member();
		member.setUserId("test");
		member.setEmail("test@update.com");
		//member.setPassword("123999000");
		member.setTell("010-1190-0112");
		mybatisRepository.dynamicQuerySetTag(member);
	}
	
	@Test
	public void dynamicQueryForeachTagWithList() {
		List<String> userList = new ArrayList<String>();
		userList.add("test");
		userList.add("CLASS");
		
		mybatisRepository
		.dynamicQueryForeachTagWithList(userList);
	}
	
	@Test
	public void dynamicQueryForeachTag() {
		//만능 insert쿼리 생성
		Map<String,Object> commandMap = new HashMap<String, Object>();
		commandMap.put("table", "tb_book");
		commandMap.put("primaryKey", Map.of("col", "b_idx","val","sc_b_idx.nextval"));
		commandMap.put("data"
				, Map.of("title","만능인서트에대한 3가지 고찰"
						,"author","피클래스"
						,"info","마이바티스의 동적쿼리를 활용하는 방법론"));
		mybatisRepository.dynamicQueryForeachTag(commandMap);
	}
	
	@Test
	public void dynamicQueryWhereAndForeachTag() {
		//검색조건을 or 연산으로 검색하기
		//대출가능, 제목, 작가
		//사용자가 입력한 키워드
		String[] searchType = {"title","author"};
		Map<String,Object> commandMap = new HashMap<String, Object>();
		commandMap.put("searchType", searchType);
		commandMap.put("keyword", "도시");
		mybatisRepository.dynamicQueryWhereAndForeachTag(commandMap);
	}
	
	@Test
	public void resultMap() {
		System.out.println(mybatisRepository.resultMap(userId));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
