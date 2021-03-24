package mybatis;

import java.util.HashMap;
import java.util.LinkedHashMap;
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

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MybatisTest {

	//selectOne : 단일 행을 반환 받는 select문 실행
	//selectList : 다중 행을 반환 받는 select문 실행
	//insert : insert, dml 메서드의 경우 결과값은 쿼리에 의해 영향을 받은 row 수
	//update : update, dml 메서드의 경우 결과값은 쿼리에 의해 영향을 받은 row 수
	//delete : delete, dml 메서드의 경우 결과값은 쿼리에 의해 영향을 받은 row 수
	//** procedure 호출을 할 경우 dml 쿼리메서드 중 선택
	@Autowired
	SqlSessionTemplate session;
	private String userId = "test";
	private final String NAMESPACE = "mapper.Mybatis.";
	
	@Test
	public void selectOneTest() {
		session.selectOne(NAMESPACE + "selectOne", userId);
	}
	
	@Test
	public void selectListReturnedAsMap() {
		List<Map<String,Object>> res = session.selectList(NAMESPACE+"selectListReturnedAsMap",userId);
		for (Map<String, Object> map : res) {
			System.out.println(map);
		}
	}
	
	@Test
	public void selectList() {
		session.selectList(NAMESPACE+"selectList");
	}
	
	@Test
	public void insertWithVo() {
		Member member = new Member();
		member.setUserId("빠빠빨간마앗");
		member.setPassword("궁금해 허니이");
		member.setEmail("test@test.com");
		member.setTell("010-0112-1190");
		session.insert(NAMESPACE+"insertWithVo",member);
	}
	
	@Test
	public void insertWithMap() {
		Map<String,Object> commandMap = new HashMap<>();
		Member member = new Member();
		
		member.setUserId(userId);
		commandMap.put("member", member);
		commandMap.put("title", "해리포터와 불사조의 기사단 외 2권");
		commandMap.put("rentBookCnt", 3);
		
		session.insert(NAMESPACE+"insertWithMap",commandMap);
	}
	
	@Test
	public void update() {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("동해물과백두산이");
		session.update(NAMESPACE+"update",member);
	}
	
	@Test
	public void procedure() {
		String bIdx = "100487";
		insertWithMap();
		session.insert(NAMESPACE+"procedure",bIdx);
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
		session.selectList(NAMESPACE+"dynamicQueryIF",commandMap);
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
		session.selectList(NAMESPACE+"dynamicQueryChoose",commandMap);
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
		
		session.update(NAMESPACE+"dynamicQuerySetTag",member);
	}
	
	@Test
	public void dynamicQueryForeachTagWithList() {
		//만능 insert쿼리 생성
		session.selectList(NAMESPACE+"dynamicQueryForeachTagWithList",List.of("test","insertTest","insertTest2"));
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
	
		session.selectList(NAMESPACE+"dynamicQueryForeachTag",commandMap);
	}
	
	@Test
	public void dynamicQueryWhereAndForeachTag() {
		//검색조건을 or 연산으로 검색하기
		//대출가능, 제목, 작가
		//사용자가 입력한 키워드
		String[] searchType = {"title","author"};
		List<Map<String,Object>> res = session.selectList(NAMESPACE+"dynamicQueryWhereAndForeachTag"
				,Map.of("searchType",searchType,"keyword","도시"));
	}
	
	
	@Test
	public void resultMap() {
		
		List<Map<String,Object>> res = session.selectList(NAMESPACE+"resultMap",userId);
		
		for (Map<String, Object> map : res) {
			System.out.println(map);
			for (String key : map.keySet()) {
				System.out.println(key + "의 타입 : " + map.get(key).getClass());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
