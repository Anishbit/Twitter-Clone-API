package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	User findByUserName(String userName);

	User findByUserID(Integer userID);
}
