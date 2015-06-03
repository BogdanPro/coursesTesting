package com.andre.mvc.database.crm.repository;

import com.andre.mvc.database.crm.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Khemrayev A.K. on 29.04.2015.
 */
public interface CoachRepository extends JpaRepository<Coach, Long> {
    public List<Coach> findByNameLikeAndSurnameLikeAndPhoneLikeAndEmailLike(String namePattern, String surnamePattern,
                                                                            String phonePattern, String emailPattern);

    public Coach findByName(String name);
}
