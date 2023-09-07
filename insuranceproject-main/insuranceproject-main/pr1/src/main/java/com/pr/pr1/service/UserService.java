package com.pr.pr1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.pr1.model.User;
import com.pr.pr1.repo.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	@Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
	
	
	public User registerUser(User user) {
		return userRepo.save(user);
	}
	public boolean validateUser(String Username,String password) {
		
		User user=userRepo.findUserByUsername(Username);
		if (user !=null && user.getPassword().equalsIgnoreCase(password) ){
			return true;
			
		}
		return false;
	}


	
	

}
