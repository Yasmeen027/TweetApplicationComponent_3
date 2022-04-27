package com.tweetapp.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Reply;

@EnableScan
@Repository
public interface ReplyRepository extends PagingAndSortingRepository<Reply,String> {

	List<Reply> findByTweetId(String tweetId);


}
