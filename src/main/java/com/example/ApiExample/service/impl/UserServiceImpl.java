package com.example.ApiExample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.ApiExample.model.User;
import com.example.ApiExample.repository.UserRepository;
import com.example.ApiExample.service.UserService;

@Component
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(String userId) {
		System.out.println("getting user by id : " + userId);
		return userRepository.findById(userId).orElse(new User());
	}

	@Override
	public User saveUser(User user) {
		System.out.println("saving user: "+ user);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		System.out.println("updating user: "+ user.getId());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		System.out.println("deleting user by id : {}"+ userId);
		userRepository.deleteById(userId);
	}

	@Override
	public User patchUser(User user) {
		System.out.println("patching user: "+ user.getId());
		return userRepository.save(user);
	}

}
