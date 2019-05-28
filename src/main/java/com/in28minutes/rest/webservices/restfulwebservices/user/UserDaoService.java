package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static int usersCount = 1;
	private static Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();
	
	static {
		users.put(usersCount, new User(usersCount, "Adam", new Date()));
		usersCount++;
		
		users.put(usersCount, new User(usersCount, "Eve", new Date()));
		usersCount++;
		
		users.put(usersCount, new User(usersCount, "Kain", new Date()));
		usersCount++;
	}
	
	public List<User> findAll() {
		List<User> all = new ArrayList<>();
		all.addAll(users.values());
		return all;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(usersCount);
		}
		users.put(user.getId(), user);
		return user;
	}
}
