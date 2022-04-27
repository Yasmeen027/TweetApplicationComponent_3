package com.tweetapp.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Getter;
import lombok.Setter;

@DynamoDBTable(tableName="tweet")
@Getter
@Setter
public class Tweets {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String tweetId;
	@DynamoDBAttribute
	private String message;
	@DynamoDBAttribute
	private String msgPostTime;
	@DynamoDBAttribute
	private Integer like;
	@DynamoDBAttribute
	private String userName;
	
	
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgPostTime() {
		return msgPostTime;
	}
	public void setMsgPostTime(String msgPostTime) {
		this.msgPostTime = msgPostTime;
	}
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
