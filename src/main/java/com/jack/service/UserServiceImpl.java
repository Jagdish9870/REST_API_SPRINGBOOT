package com.jack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.entity.User;
import com.jack.repository.UserRepo;
@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
	@Override
	public User updateUser(int id, User newUser) {

		
			User userData= userRepo.findById(id).orElse(null);
			
			if(userData !=null) {
				
				return userRepo.save(newUser);
			}
			else {
				throw new RuntimeException("user not exist with id : "+id);
			}
	}

	@Override
	public void deleteUser(int id) {
		 userRepo.deleteById(id);;
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}
	@Override
	public Optional<User> getOneUser(int id) {
		return userRepo.findById(id);
		
	}
	

	

}
