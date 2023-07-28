package com.luan.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.luan.domain.model.User;
import com.luan.domain.repository.UserRepository;
import com.luan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This account number already exists.");
		}
		return userRepository.save(userToCreate);
	}

}
