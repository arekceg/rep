package com.arek.tweeter.tweet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
	List<Tweet> getTweetsByUser_Id(Long id);
	List<Tweet> getTweetsByTweetTextStartsWith(String string);

}
