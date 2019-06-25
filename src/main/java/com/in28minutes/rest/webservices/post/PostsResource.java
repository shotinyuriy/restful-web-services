package com.in28minutes.rest.webservices.post;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.user.User;
import com.in28minutes.rest.webservices.user.UserDaoService;
import com.in28minutes.rest.webservices.user.UserNotFoundException;

@RestController
public class PostsResource {

	@Autowired
	private PostDaoService postDaoService;
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users/{userId}/posts")
	public List<Post> retrieveAllPostsForUser(@PathVariable Integer userId) {
		return postDaoService
				.filter(post -> post.getUserId() == userId)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/users/{userId}/posts/{postId}")
	public Post retriveOnePostForUser(@PathVariable Integer userId,
			@PathVariable Integer postId) {
		return postDaoService
				.filter(post -> post.getUserId() == userId)
				.filter(post -> post.getId() == postId)
				.findFirst()
				.orElseThrow(() -> {
					return new PostNotFoundException("Post with id="+postId+" is not found for user with id "+userId);					
				});
	}
	
	@PostMapping("/users/{userId}/posts")
	public ResponseEntity addPostForUser(@PathVariable Integer userId, @RequestBody Post post) {
		User user = userDaoService.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User with id="+userId+" is not found");
		}
		post.setUserId(user.getId());
		if (post.getPostedAt() == null) {
			post.setPostedAt(new Date());
		}		
		Post savedPost = postDaoService.save(post);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{postId}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
