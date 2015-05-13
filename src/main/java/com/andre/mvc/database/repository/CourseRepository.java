package com.andre.mvc.database.repository;

import com.andre.mvc.database.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 1 on 05.05.2015.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByNameLike(String namePattern);

    public Course findByName(String name);
}
