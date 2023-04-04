package com.chrisflores.calendariospring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisflores.calendariospring.data.ResponseSignin;
import com.chrisflores.calendariospring.data.User;
import com.chrisflores.calendariospring.data.UserRepository;
import com.chrisflores.calendariospring.security.Hashing;

@Service
public class UserService {
	@Autowired
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//Return user data if sign in is good. Otherwise return null
	public User signIn(String username, String password) {
		Iterable<User> users = userRepository.findByUsername(username);
		if (!users.iterator().hasNext())
			return null;
		User user = users.iterator().next();
		byte[] hashedPassword;
		
		try {
			hashedPassword = Hashing.getHash(password, user.getSalt()); //getsalt from db
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
		
		if(Arrays.equals(hashedPassword, user.getHashedPassword())) {
			return user;			
		}else
			return null;
	}
	
	public User addUser(ResponseSignin response) {
		
		if(userRepository.findByUsername(response.getUsername()).iterator().hasNext())
			return null;
		System.out.println("creating new user");
		User user = new User();
		user.setFirstName(response.getFirstName());
		user.setLastName(response.getLastName());
		user.setEmail(response.getEmail());
		user.setUsername(response.getUsername());
		
		byte[] salt = Hashing.getSalt();
		byte[] hashedPassword;
		
		try {
			hashedPassword = Hashing.getHash(response.getPassword(), salt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		user.setHashedPassword(hashedPassword);
		user.setSalt(salt);
		System.out.println("About to save to db: " + user.toString());
		this.userRepository.save(user);
		return user;
	}
	
}
