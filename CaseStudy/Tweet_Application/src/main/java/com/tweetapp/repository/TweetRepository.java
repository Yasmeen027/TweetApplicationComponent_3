package com.tweetapp.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Tweets;

@EnableScan
@Repository
public interface TweetRepository extends PagingAndSortingRepository<Tweets,String>{

	List<Tweets> findByUserName(String userName);

}
