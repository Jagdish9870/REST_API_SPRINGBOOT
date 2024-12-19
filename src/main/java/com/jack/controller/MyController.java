package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.entity.User;
import com.jack.service.UserService;

@RestController
public class MyController {
	@Autowired
	private UserService userService;
	@PostMapping("/adduser")
	public User addUserDetails(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	@GetMapping("/alluser")
	public List<User> allUserDetails() {
		
		return userService.getAllUser();
	}
	
	@GetMapping("/oneUser/{id}")
	public ResponseEntity<User> oneUserDetails(@PathVariable int id) {
		
		User user= userService.getOneUser(id).orElse(null);
		if(user != null)
		{
			return ResponseEntity.ok().body(user);
			
		}
		else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
		
		@PutMapping("/updateUser/{id}")
		public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user) {
			
			User updatedUser= userService.updateUser(id,user);
			if(updatedUser != null)
			{
				return ResponseEntity.ok(updatedUser);
				
			}
			else {
				
				return ResponseEntity.notFound().build();
			}

}
		@DeleteMapping("/deleteUser/{id}")
		public ResponseEntity<Void> deleteoneUserDetails(@PathVariable int id) {
			
			userService.deleteUser(id);
			return ResponseEntity.noContent().build();
			
			
		}
	}
