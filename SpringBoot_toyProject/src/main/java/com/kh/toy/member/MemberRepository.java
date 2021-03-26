package com.kh.toy.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository  extends JpaRepository<Member, String>{
	Member findByUserIdAndIsLeave(String userId, int isLeave);
	boolean existsByEmail(String email);
	boolean existsByTell(String tell);
}
