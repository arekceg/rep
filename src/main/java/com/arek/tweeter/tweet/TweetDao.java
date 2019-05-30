package com.arek.tweeter.tweet;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Deprecated
@Repository
@Transactional
public class TweetDao {

	@PersistenceContext
	private EntityManager em;

	public List<Tweet> getTweetsByUserId(Long id){
		return em.createQuery("SELECT t FROM Tweet t WHERE t.user.id = :id")
				.setParameter("id",id)
				.getResultList();
	}

	public List<Tweet>  getTweetsBeginningWith(String string){
		String searchStringQuery = string+"%";
		return em.createQuery("SELECT t FROM Tweet t WHERE t.tweetText LIKE :search" +
				" ORDER BY t.created DESC")
				.setParameter("search", searchStringQuery)
				.getResultList();
	}

	public List<Tweet>  getAllTweets() {
		return em.createQuery("SELECT t FROM Tweet t")
				.getResultList();

	}

	public void addTweet(Tweet tweet) {
		em.persist(tweet);
	}
}
