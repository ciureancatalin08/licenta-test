package com.example.homeservice.repository;

import com.example.homeservice.entity.HomeEntity;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<HomeEntity,Long> {
}
