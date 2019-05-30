package com.arek.tweeter.user;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Deprecated
@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public List<User> getAllUsersWithTweets() {
		return em.createQuery("SELECT u FROM User u")
				.getResultList();
	}

	public List getAllUsers() {
		return em.createQuery("SELECT u FROM User u")
				.getResultList();
	}

	public void addUser(User user) {
		em.persist(user);
	}

	public void updateUser(User updatedUser) {
		em.merge(updatedUser);
	}

	public User findUserById(Long id) {
		return em.find(User.class, id);
	}

	public User getUserById(Long id) {
		return em.find(User.class, id);
	}

	public void deleteUserById(Long id) {
		em.createNativeQuery("DELETE FROM tweeter_tweet WHERE user_id = ?1")
				.setParameter(1,id).executeUpdate();
		em.remove(findUserById(id));
	}
}
