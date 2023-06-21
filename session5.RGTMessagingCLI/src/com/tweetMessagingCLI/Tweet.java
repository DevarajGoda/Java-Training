package com.tweetMessagingCLI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tweet {

	private String tweetId;
	private String content;
	private String author;
	private LocalDateTime timestamp;

	private int likeCount;
	private List<String> likedUser;
	private List<Tweet> reTweets;
	private List<Tweet> replys;

	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public List<String> getLikedUser() {
		return likedUser;
	}

	public void setLikedUser(List<String> likedUser) {
		this.likedUser = likedUser;
	}

	public List<Tweet> getReTweets() {
		return reTweets;
	}

	public void setReTweets(List<Tweet> reTweets) {
		this.reTweets = reTweets;
	}

	public List<Tweet> getReplys() {
		return replys;
	}

	public void setReplys(List<Tweet> replys) {
		this.replys = replys;
	}

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
		this.likeCount = 0;
		this.likedUser = new ArrayList<>();
		this.replys = new ArrayList<>();
		this.reTweets = new ArrayList<>();
	}

	public Tweet() {
		super();
	}

	public void likedUsers() {
		likeCount++;
		likedUser.add(currentUser.getUserName());
		System.out.println("you liked the tweet");
	}

	public void replies() {
		Tweet tw = new Tweet(tweetId, content, currentUser.getUserName(), LocalDateTime.now());
		replys.add(tw);
	}

	public void retweets() {
		Tweet tw = new Tweet(tweetId, content, currentUser.getUserName(), LocalDateTime.now());
		reTweets.add(tw);
	}

}
