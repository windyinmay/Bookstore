package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.User;
import com.example.bookstore.repository.UserCrudRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserCrudRepository repository;
	@Autowired
	public UserDetailServiceImpl(UserCrudRepository userRepository) {
	this.repository = userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException {
	User curruser = repository.findByUsername(username);
	UserDetails user = new org.springframework.security.core.userdetails.User(username,
	curruser.getPasswordHash(),
	AuthorityUtils.createAuthorityList(curruser.getRole()));
	return user;
	} 	

}
