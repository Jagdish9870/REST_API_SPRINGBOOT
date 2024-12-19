package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	

}
