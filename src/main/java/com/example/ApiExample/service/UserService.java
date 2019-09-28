package com.example.ApiExample.service;

import org.springframework.stereotype.Service;

import com.example.ApiExample.model.User;

@Service
public interface UserService {
    default String getApiVersion() { return "v1.0"; }
    
	public User getUser(String userId);
	
	public User saveUser(User user);
	
	public User updateUser(User user);
	
	public User patchUser(User user);
	
	public void deleteUser(String userId);
}
