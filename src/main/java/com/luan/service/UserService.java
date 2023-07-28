package com.luan.service;

import com.luan.domain.model.User;

public interface UserService {
	User findById(Long id);
	
	User create(User userToCreate);
}
