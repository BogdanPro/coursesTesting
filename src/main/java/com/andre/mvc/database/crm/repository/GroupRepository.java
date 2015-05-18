package com.andre.mvc.database.crm.repository;

import com.andre.mvc.database.crm.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 1 on 24.04.2015.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    public List<Group> findByNameLike(String namePattern);

    public Group findByName(String name);
}
