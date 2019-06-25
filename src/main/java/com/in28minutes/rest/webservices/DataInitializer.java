package com.in28minutes.rest.webservices;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.post.Post;
import com.in28minutes.rest.webservices.post.PostDaoService;
import com.in28minutes.rest.webservices.user.User;
import com.in28minutes.rest.webservices.user.UserDaoService;

@Component
public class DataInitializer {

	@Autowired
	UserDaoService userDaoService;
	
	@Autowired
	PostDaoService postDaoService;
	
	@PostConstruct
	public void initialize() {
			User adam = userDaoService.save(new User("Adam", new Date()));		
			User eve = userDaoService.save(new User("Eve", new Date()));
			User kain = userDaoService.save(new User("Kain", new Date()));
			userDaoService.save(new User("Avel", new Date()));
			
			Post postAdam1 = new Post(adam.getId(), "Hello! this is Adam.");
			Post postEve1 = new Post(eve.getId(), "Hello, Adam! This is Eve.");
			Post postAdam2 = new Post(adam.getId(), "Hi, Eve! I like you.");
			Post postKain = new Post(kain.getId(), "Greetings to you, my parents");
			Post postEve2 = new Post(eve.getId(), "Hi, Kain! You are looking good today.");
			
			postDaoService.save(postAdam1);
			postDaoService.save(postEve1);
			postDaoService.save(postAdam2);
			postDaoService.save(postKain);
			postDaoService.save(postEve2);
	}
}
