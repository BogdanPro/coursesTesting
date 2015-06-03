package com.andre.mvc.database.crm.repository;

import com.andre.mvc.database.crm.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Khemrayev A.K. on 06.05.2015.
 */
public interface PlaceRepository extends JpaRepository<Place, Long> {

    public Place findByName(String name);
}
