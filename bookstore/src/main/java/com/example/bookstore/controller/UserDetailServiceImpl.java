package com.example.bookstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> curruserOpt = repository.findByUsername(username);
		if (curruserOpt.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		User curruser = curruserOpt.get();

		return new org.springframework.security.core.userdetails.User(
				curruser.getUsername(),
				curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
	}
}