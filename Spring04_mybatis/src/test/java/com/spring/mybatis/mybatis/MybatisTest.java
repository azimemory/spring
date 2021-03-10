package com.spring.mybatis.mybatis;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.spring.mybatis.member.model.vo.Member;


//시작 전 
// * oracle6 드라이버를 프로젝트 빌드패스에 추가하고 시작할 것.
// * mybatis의 config.xml 파일에서 mapper 경로 확인. mapper resource 경로 앞에 '/'있으면 안된다.

//프로젝트의 web.xml이 아니라 테스트를 위해 
//자동으로 생성되는 가상의 web.xml을 사용하겠다는 의미
@WebAppConfiguration

//@RunWith : Junit 프레임워크의 테스트 실행방법을 변경할때 지정
//SpringJUnit4ClassRunner.class : 
//			테스트를 진행할 때 사용할 applicationContext를 만들고 관리한다.
@RunWith(SpringJUnit4ClassRunner.class)

//자동으로 생성되는 applicationContext의 설정파일 위치를 지정
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})

public class MybatisTest {

	@Autowired
	private SqlSessionTemplate session;
	
	private String userId = "test";
	
	@Test
	public void deleteTest() {
		session.delete("mapper.Mybatis.deleteTest",userId);
	}

	@Test
	public void selectIdTest() {
		Member member = session.selectOne("mapper.Mybatis.selectOneTest",userId);
		assertEquals(userId, member.getUserId());
	}
	
	@Test
	public void selectListTest() {
		List<Member> memberList = session.selectList("mapper.Mybatis.selectListTest");
	}
	
	@Test
	public void insertTest() {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("112119");
		member.setTell("010-0112-0119");
		member.setEmail("police@gov.com");
		int res = session.insert("mapper.Mybatis.insertTest",member);
	}
	
	@Test
	public void updateTest() {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("happy");
		int res = session.update("mapper.Mybatis.updateTest",member);
	}
	
	@Test
	public void storedProcedureTest() {
		String bIdx = "100043";
		
		Map<String,String> rentInfo = new HashMap<>();
		rentInfo.put("userId", userId);
		rentInfo.put("title", "달콤한 나의 도시");
		rentInfo.put("rentBookCnt", "1");
		
		session.insert("mapper.Mybatis.insertRentInfo",rentInfo);
		session.insert("mapper.Mybatis.insertRentBookInfo",bIdx);
	}
	
	@Test
	public void selectIfTest() {
		//사용자가 도서 검색필터에서 도서내용을 선택하고 검색하면 입력키워드로 info  검색
		//사용자가 도서 검색필터에서 도서제목을 선택하고 검색하면 입력키워드로 title 검색
		Map<String,String> command = new HashMap<String, String>();
		command.put("searchType","info");
		command.put("keyword","다");
		List<Map> res = session.selectList("mapper.Mybatis.selectIfTest",command);
	}
	
	@Test
	public void insertForeachTest() {
		Map<String,Object> command = new HashMap<String, Object>();
	
		String[] promaryKey = {"bk_idx","sc_bk_idx.nextval"}; 	
		command.put("table","book"); 	//테이블 지정
		command.put("primaryKey",promaryKey); //기본키 설정
		
		Map<String,String> data = new HashMap<String, String>();
		data.put("title","템플릿도서");
		data.put("author","우리");
		data.put("info","만능인서트");
		command.put("data",data);
		
		session.insert("mapper.Mybatis.insertForeachTest",command);
	}
	
	@Test
	public void updateSetTagTest() {
		//회원정보 수정
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("변경된비밀번호");
		member.setEmail("change@test.com");
		List<Member> res = session.selectList("mapper.Mybatis.updateSetTagTest",member);
	}
	
	@Test
	public void selectWhereTagTest() {
		//검색조건 or 연산으로 검색하기
		//대출가능, 제목, 작가
		Map<String,Object> command = new HashMap<String, Object>();
		String[] searchTypes = {"title","author"};
		command.put("searchTypes",searchTypes);
		command.put("keyword","다");
		session.selectList("mapper.Mybatis.selectWhereTagTest",command);
	}
	
	@Test
	public void selectRentbookinfo() {
		//검색조건 or 연산으로 검색하기
		//대출가능, 제목, 작가
		Map<String,String> command = new HashMap<String, String>();
		command.put("searchType","rbIdx");
		command.put("idx","100023");
		Map<String,Object> res = session.selectOne("mapper.Mybatis.selectRentbookinfo",command);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
