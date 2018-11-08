package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计推特
 * https://leetcode-cn.com/submissions/detail/9149980/
 * 
 * [Solution]
 * http://www.cnblogs.com/reboot329/p/5875843.html
 */
public class Test140 {

	class Twitter {
	    //对数据结构的运用
	    List<Message> list;
	    List<Integer> follow;
	    
	    class Message {
	        public int userId;
	        public int tweetId;
	        
	        public  Message(int userId, int tweetId) {
	            this.userId = userId;
	            this.tweetId = tweetId;
	        }
	    }
	    
	    /** Initialize your data structure here. */
	    public Twitter() {
	        follow = new ArrayList<>();
	        follow.add(1);
	        list = new ArrayList<>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        if (follow.contains(userId))
	            list.add(new Message(userId,tweetId));
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	        List<Integer> res = new ArrayList<>();
	        for (int i=0; i<list.size(); i++) {
	            res.add(list.get(i).tweetId);
	            if (res.size() == 10) break;
	        }
	        return res;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
//	        follow.add()
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        
	    }
	}
}
