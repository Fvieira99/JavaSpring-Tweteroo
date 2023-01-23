package com.tweteroo.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model._Tweet;


public interface TweetRepository extends JpaRepository<_Tweet, Long> {

  List<_Tweet> findAllByUsername(String username);
}
