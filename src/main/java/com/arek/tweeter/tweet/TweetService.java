package com.arek.tweeter.tweet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {

//	private TweetDao tweetDao;
	private TweetRepository tweetRepository;

	public List<Tweet> getTweetsFromUserId(Long id){
		return tweetRepository.getTweetsByUser_Id(id);
//		return tweetDao.getTweetsByUserId(id);
	}

	public List<Tweet> getTweetsBeginningWithString(String string){
		return tweetRepository.getTweetsByTweetTextStartsWith(string);
//		return tweetDao.getTweetsBeginningWith(string);
	}

	List<Tweet> getAllTweets() {
		return tweetRepository.findAll();
//		return tweetDao.getAllTweets();
	}

	void addTweet(Tweet tweet) {
		tweetRepository.save(tweet);
//		tweetDao.addTweet(tweet);
	}
}
