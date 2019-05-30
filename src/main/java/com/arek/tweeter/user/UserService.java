package com.arek.tweeter.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

//	private UserDao userDao;
	private UserRepository userRepository;

	public List<User> getAllUsers(){
		return userRepository.findAll();
//		return userDao.getAllUsers();
	}

	public void addUser(User user){
		userRepository.save(user);
//		userDao.addUser(user);
	}


	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
//		return userDao.getUserById(id);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteUserRelationsWithTweets(id);
		userRepository.deleteById(id);
	}
}
