package com.tweetMessagingCLI;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
public class Tweet {
	
	private String tweetId;
	private String content;
	private String author;
	private LocalDateTime timestamp;
	
	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public Tweet(String tweetId, String content, String author, LocalDateTime timestamp) {
		super();
		this.tweetId = tweetId;
		this.content = content;
		this.author = author;
		this.timestamp = timestamp;
	}

	public Tweet() {
		super();
	}


}
