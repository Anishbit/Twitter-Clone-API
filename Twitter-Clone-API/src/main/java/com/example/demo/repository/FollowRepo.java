package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Follow;

@Repository
public interface FollowRepo extends CrudRepository<Follow, Integer> {

	ArrayList<Follow> findAllByUserId(int userId);

}
