package com.jack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jack.entity.User;

public interface UserService {
	public User createUser(User user);
	public User updateUser(int id, User user);
	public void deleteUser(int id);
	public List<User> getAllUser();
	public Optional<User> getOneUser(int id);

}
