package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.tweetapp.kafka.Producer;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.model.User;
import com.tweetapp.service.TweetService;
import com.tweetapp.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class UserTweetController {

	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetservice;

	//public Producer producer;

	@PostMapping(path = "/register")
	public User registerUSer(@RequestBody User user) {
		return userService.registerUser(user);

	}

	@PostMapping(path = "/login")
	public User loginUser(@RequestBody User user) {
		User loggedInUser = userService.loginUser(user);
		System.out.println(loggedInUser);
		return loggedInUser;

	}

	@PostMapping(path = "/{userName}/forgot")
	public User updatePassword(@RequestBody User user, @PathVariable String userName) {
		User loggedInUser = userService.updatePassword(user, userName);
		System.out.println(loggedInUser);
		return loggedInUser;

	}

	@GetMapping(path = "/user/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/user/search/{userName}")
	public User getUserByName(@PathVariable String userName) {
		return userService.getUserByName(userName);
	}

	@PostMapping(path = "/{userName}/add")
	public Tweets postTweet(@RequestBody Tweets tweet, @PathVariable String userName) {
		return tweetservice.postTweet(tweet, userName);

	}

	@GetMapping(path = "/all")
	public List<Tweets> getAllTweets() {
		List<Tweets> tweet = tweetservice.getAllTweets();
		return tweet;
	}

	@PutMapping(path = "/update/{tweetId}")
	public Tweets updateTweet(@RequestBody Tweets tweet, @PathVariable String tweetId) {
		Tweets updatedTweet = tweetservice.updateTweet(tweet, tweetId);
		return updatedTweet;
	}

	@DeleteMapping(path = "/delete/{tweetId}")
	public void deleteTweet(@PathVariable String tweetId) {
		tweetservice.deleteTweetbyId(tweetId);

	}

	@PostMapping(path = "/{userName}/reply")
	public Reply postReply(@RequestBody Reply reply) {
		return tweetservice.postReply(reply);

	}

	@GetMapping(path = "/all/{userName}")
	public List<Tweets> getTweetByUser(@PathVariable String userName) {
		return tweetservice.getTweetsByUser(userName);
	}

	@GetMapping(path = "/getReply/{tweetId}")
	public List<Reply> getTweetReply(@PathVariable String tweetId) {
		return tweetservice.getTweetsReply(tweetId);
	}

//	@Autowired
//	UserTweetController(Producer producer) {
//		this.producer = producer;
//
//	}
//
//	@GetMapping("/publish")
//	public String sendMessage(@PathVariable String message) {
//		this.producer.sendMessage(message);
//		return "connection established";
//
//	}

}
