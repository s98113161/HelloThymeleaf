package com.kang.HelloThymeleaf.dao;

import java.util.ArrayList;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Component;

import com.kang.HelloThymeleaf.model.User;
@Component
public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllUser() {
		//--random names
		DataFactory df = new DataFactory();
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUserId(i);
			String name = df.getFirstName() + " "+ df.getLastName();
			user.setUserName(name);
			if (i % 5 == 1) {
				user.setUserEnable(false);
			} else {
				user.setUserEnable(true);
			}
			if (i % 10 == 0) {
				user.setUserRole("admin");
			} else {
				user.setUserRole("user");
			}
			users.add(user);
		}
		return users;
	}

}
