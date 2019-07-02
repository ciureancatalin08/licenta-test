package com.example.homeservice.repository;

import com.example.homeservice.entity.HomeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HomeRepository extends CrudRepository<HomeEntity,Long> {
    @Modifying
    @Query("update   HomeEntity h Set h.lights= :state")
    void setLigths(@Param("state") String state);
}
