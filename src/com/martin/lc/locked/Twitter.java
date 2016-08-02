package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Twitter {
	public static class User{
        public List<Integer> tweets;
        public HashSet<Integer> following;
        public HashSet<Integer> followers;
        public int userId;
        public User(int id){
            this.userId = id;
            this.tweets = new ArrayList<Integer>();
            this.following = new HashSet<Integer>();
            this.followers = new HashSet<Integer>();
        }
       
    }
    
    private HashMap<Integer,User> users;
    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashMap<Integer,User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) users.put(userId,new User(userId));
        //add in user's own timeline
        users.get(userId).tweets.add(tweetId);
        //push to all followers tweets
        for(Integer in : users.get(userId).followers){
            if(users.containsKey(in)){
                users.get(in).tweets.add(tweetId);
            }
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if(!users.containsKey(userId)) return res;
        int size = users.get(userId).tweets.size();
        for(int i = 1;i<=10;i++){
            if( size-i < 0) break;
            res.add(users.get(userId).tweets.get(size-i));
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) return;
        if(!users.containsKey(followeeId)) return;
        users.get(followeeId).followers.add(followerId);
        users.get(followerId).following.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) return;
        if(!users.containsKey(followeeId)) return;
        if(users.get(followerId).following.contains(followeeId)){
            users.get(followerId).following.remove(followeeId);
        }
        if(users.get(followeeId).following.contains(followerId)){
            users.get(followeeId).followers.remove(followerId);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		Date d2 = new Date();
		int rr = d1.compareTo(d2);
		System.out.println();
	}

}
