package com.andre.mvc.database.crm.repository;

import com.andre.mvc.database.crm.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Khemrayev A.K. on 05.05.2015.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByNameLike(String namePattern);

    public Course findByName(String name);
}
