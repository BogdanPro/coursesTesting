package com.andre.mvc.database.repository;

import com.andre.mvc.database.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1 on 06.05.2015.
 */
public interface PlaceRepository extends JpaRepository<Place, Long> {

    public Place findByName(String name);
}