package com.tweetapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.repository.ReplyRepository;
import com.tweetapp.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private ReplyRepository replyRepository;

	@Override
	public List<Tweets> getAllTweets() {
		List<Tweets> allTweets = new ArrayList<Tweets>();
		try {
			allTweets = (List<Tweets>) tweetRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTweets;
	}

	@Override
	public Tweets postTweet(Tweets tweet, String userName) {
		Tweets savedTweet=new Tweets();
		try {
		tweet.setUserName(userName);
		savedTweet= tweetRepository.save(tweet);}
		catch (Exception e) {
			e.printStackTrace();
		}
		return savedTweet;
	}

	@Override
	public Tweets updateTweet(Tweets tweet, String tweetId) {
		tweet.setTweetId(tweetId);
		return tweetRepository.save(tweet);
	}

	@Override
	public void deleteTweetbyId(String tweetId) {
		// TODO Auto-generated method stub

		try {
			tweetRepository.deleteById(tweetId);
			replyRepository.deleteById(tweetId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public Reply postReply(Reply reply) {
		Reply tweetReply = new Reply();
		try {
			tweetReply = replyRepository.save(reply);

		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return tweetReply;
	}

	@Override
	public List<Tweets> getTweetsByUser(String userName) {
		
		return tweetRepository.findByUserName(userName);
	}

	@Override
	public List<Reply> getTweetsReply(String tweetId) {
		// TODO Auto-generated method stub
		return replyRepository.findByTweetId(tweetId);
	}


}
