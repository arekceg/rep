package com.arek.tweeter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Query(value = "DELETE FROM tweeter_tweet WHERE user_id = :id", nativeQuery = true)
	void deleteUserRelationsWithTweets(@Param("id") Long id);
}
