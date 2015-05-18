package com.andre.mvc.database.forum.repository;

import com.andre.mvc.database.forum.entity.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1 on 18.05.2015.
 */
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

    public MemberGroup findByName(String name);
}
