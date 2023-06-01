package com.example.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.security.model.MyUserDetails;
import com.example.security.model.User;
import com.example.security.repo.UserRepository;

public class MyUserDetailsService {

	@Autowired
	UserRepository repo;

	//@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = repo.findByUserName(username);
		user.orElseThrow(() -> (new UsernameNotFoundException("Not Found: " + username)));

		return user.map(MyUserDetails::new).get();
	}

}
