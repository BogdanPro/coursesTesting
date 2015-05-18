package com.andre.mvc.database.forum.repository;

import com.andre.mvc.database.forum.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Андрей on 17.05.2015.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByName(String name);
}
