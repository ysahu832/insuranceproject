package com.pr.pr1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pr.pr1.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);

}
