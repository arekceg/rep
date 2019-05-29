package com.arek.tweeter.user;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;

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
}
