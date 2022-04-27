package com.tweetapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.User;
import com.tweetapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		User savedUser = new User();
		try {
			if (user != null) {
				savedUser = userRepository.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedUser;

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getTweetsByUser(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findTweetsByuserName(userName);
	}

	@Override
	public User loginUser(User login) {
		// TODO Auto-generated method stub
		boolean status = false;
		User loggedinUser=new User();
		List<User> user = (List<User>) userRepository.findAll();
		for(int i=0;i<user.size();i++)
		{
		if(user.get(i).getPassword().equals(login.getPassword())&&user.get(i).getUserName().equals(login.getUserName()))
		{
			status = true;
			loggedinUser.setUserName(user.get(i).getUserName());
			loggedinUser.setUserId(user.get(i).getUserId());
		}
		}
		
		return loggedinUser;
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	@Override
	public User updatePassword(User user, String userName) {
		User updateUser=userRepository.findByUserName(userName);
		User updatedPassword=new User();
		try {
		if(updateUser!=null) {
		updateUser.setPassword(user.getPassword());
		updateUser.setConfirmPassword(user.getConfirmPassword());
		 updatedPassword=userRepository.save(updateUser);}}
		catch (Exception e) {
			e.printStackTrace();
		}
		return updatedPassword;
	}

}
