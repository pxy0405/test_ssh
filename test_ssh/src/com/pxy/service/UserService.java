package com.pxy.service;

import java.util.List;

import com.pxy.model.User;

public interface UserService {

	User login(User user);

	List<User> list();

	void register(User user);

	User findByID(Integer iD);

	void edit(User user);

	void delete(Integer iD);

	User findByUserName(String userName);

}
