package com.in28minutes.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.post.Post;

@Component
public class UserDaoService {

	private static int usersCount = 1;
	private static Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();
	
	public List<User> findAll() {
		List<User> all = new ArrayList<>();
		all.addAll(users.values());
		return all;
	}
	
	public User findOne(Integer id) {
		return users.get(id);
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(usersCount++);
		}
		users.put(user.getId(), user);
		return user;
	}
	
	public Stream<User> filter(Predicate<User> predicate) {
		return users.values().stream().filter(predicate);
	}
	
	public User deleteById(Integer id) {
		return users.remove(id);
	}
}
