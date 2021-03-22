package com.kh.toy.member.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kh.toy.member.model.vo.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
	Member save(Member member);
	Member findByUserIdAndIsLeave(String userId,int isLeave);
	boolean existsByEmail(String email);
	boolean existsByTell(String tell);
}
