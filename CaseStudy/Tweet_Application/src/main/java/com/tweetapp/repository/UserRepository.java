package com.tweetapp.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.User;

@EnableScan
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,String> {

	User findTweetsByuserName(String userName);

	//@Query("{'userName': ?0}")
	User findByUserName(String userName);
		
}
