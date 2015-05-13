package com.andre.mvc.database.repository;

import com.andre.mvc.database.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 1 on 21.04.2015.
 */

public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client> findByNameLikeAndSurnameLikeAndPhoneLikeAndEmailLikeAndTagsLike(String namePattern, String surnamePattern, String phonePattern, String emailPattern, String tagsPattern);

//    public Client findByEmail(String email);

    public Client findByPhone(String phone);
}
