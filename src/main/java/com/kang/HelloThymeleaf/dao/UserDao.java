package com.kang.HelloThymeleaf.dao;

import java.util.ArrayList;
import java.util.List;

import com.kang.HelloThymeleaf.model.User;

public interface UserDao {
	public void add(User user);
	public void edit(User user);
	public void delete(int userId);
	public User getUser(int userId);
	public ArrayList<User> getAllUser();
}
