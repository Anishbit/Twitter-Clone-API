package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LikeTable;

@Repository
public interface LikeRepo extends CrudRepository<LikeTable, Integer> {

}
