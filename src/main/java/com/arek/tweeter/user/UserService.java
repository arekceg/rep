package com.arek.tweeter.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

	private UserDao userDao;

	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	public void addUser(User user){
		userDao.addUser(user);
	}
}
