package com.in28minutes.rest.webservices.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {

	private static int postCount = 1;
	private static Map<Integer, Post> posts = new ConcurrentHashMap<>();
	
	public PostDaoService() {
		save(new Post());
	}
	
	public List<Post> findAll() {
		List<Post> all = new ArrayList<>();
		all.addAll(posts.values());
		return all;
	}
	
	public Post findOne(Integer id) {
		return posts.get(id);
	}
	
	public Post save(Post post) {
		if (post.getId() == null) {
			post.setId(postCount++);
		}
		posts.put(post.getId(), post);
		return post;
	}
	
	public Stream<Post> filter(Predicate<Post> predicate) {
		return posts.values().stream().filter(predicate);
	}
}
