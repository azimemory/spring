package com.kh.toy.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.kh.toy.common.util.jpa.MergeEntity;
import com.kh.toy.common.util.jpa.MergeEntityBuilder;
import com.kh.toy.member.Member;

@SpringBootTest
public class jpaUtilTest {
	
	@Test
	public void jpaUtilTest() {
		Member entity = new Member();
		Member vo = new Member();
		entity.setUserId("azimemory");
		entity.setPassword("123qwe!@#");
		vo.setEmail("azimemory@gmail.com");
		vo.setTell("010-1111-222");
		
		try {
			System.out.println(entity.getClass().getField("userId"));
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MergeEntity<Member> merge = new MergeEntityBuilder<Member>()
								.entity(entity).vo(vo).build();
		
		System.out.println(merge.get());
		int i = 10/0;
	}
}
