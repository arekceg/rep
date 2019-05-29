package com.arek.tweeter.tweet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {

	private TweetDao tweetDao;

	public List<Tweet> getTweetsFromUserId(Long id){
		return tweetDao.getTweetsByUserId(id);
	}

	public List<Tweet> getTweetsBeggningWithString(String string){
		return tweetDao.getTweetsBeginningWith(string);
	}

	public List<Tweet> getAllTweets() {
		return tweetDao.getAllTweets();
	}

	public void addTweet(Tweet tweet) {
		tweetDao.addTweet(tweet);
	}
}
