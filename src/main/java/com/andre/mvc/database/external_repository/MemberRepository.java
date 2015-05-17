package com.andre.mvc.database.external_repository;

import com.andre.mvc.database.external_entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Андрей on 17.05.2015.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
