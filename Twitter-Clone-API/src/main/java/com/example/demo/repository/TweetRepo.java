package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tweet;
import com.example.demo.model.User;

@Repository
public interface TweetRepo extends CrudRepository<Tweet, Integer> {

	ArrayList<Tweet> findAllByUser(User foundUser);

}
