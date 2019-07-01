package com.example.homeservice.repository;

import com.example.homeservice.home.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<Home,Long> {
}
