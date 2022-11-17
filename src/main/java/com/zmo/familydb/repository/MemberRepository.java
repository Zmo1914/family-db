package com.zmo.familydb.repository;

import com.zmo.familydb.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}