package com.example.homeservice.repository;

import com.example.homeservice.entity.HomeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HomeRepository extends CrudRepository<HomeEntity, Long> {
    @Modifying
    @Query("update HomeEntity h Set h.lights= :state where h.userName= :userName")
    void setLigths(@Param("state") String state, @Param("userName") String userName);

    @Modifying
    @Query("update   HomeEntity h Set h.coolingFans= :state where h.userName= :userName")
    void setFans(@Param("state") String state, @Param("userName") String userName);

    @Modifying
    @Query("update   HomeEntity h Set h.alarms= :state where h.userName= :userName")
    void setAlarms(@Param("state") String state, @Param("userName") String userName);



    @Modifying
    @Query("update   HomeEntity h Set h.humidity= :humidity,h.temperature= :temperature,h.heatIndex= :heatIndex where h.userName= :userName")
    void setData(@Param("temperature") int temperature, @Param("humidity") int humidity, @Param("heatIndex") int heatIndex, @Param("userName") String userName);


    @Query("select h from  HomeEntity h where h.userName= :userName")
    HomeEntity getData( @Param("userName") String userName);
}
