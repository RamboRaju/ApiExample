package com.example.ApiExample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiExample.model.User;
import com.example.ApiExample.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		return userService.getUser(userId);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		 return userService.saveUser(user);
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return "Successfully deleted user for id: " + userId;
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user, @PathVariable String userId) {
		user.setId(userId);
		return userService.updateUser(user);
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.PATCH)
	public User patchUser(@RequestBody User user, @PathVariable String userId) {
		user.setId(userId);
		User prevUserVersion = userService.getUser(userId);
		System.out.println("before patch: " + prevUserVersion.getId() + " " + prevUserVersion.getName());
		BeanUtils.copyProperties(user, prevUserVersion);
		return userService.patchUser(prevUserVersion);
	}
}
