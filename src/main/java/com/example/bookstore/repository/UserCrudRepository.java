package com.example.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.domain.User;

public interface UserCrudRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
