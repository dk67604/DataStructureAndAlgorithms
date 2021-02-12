package main.java.systemdesign;

import java.util.*;

public class Twitter {
    private static int timeStamp = 0;

    //User map
    private Map<Integer, User> userMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId)) return res;
        Set<Integer> users = userMap.get(userId).followed; // get all the users followed by userid
        // create a max-heap using timestamp of Tweet
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            // get the tweet head of all users
            Tweet t = userMap.get(user).tweetHead;
            if (t != null) {
                maxHeap.offer(t);
            }
        }
        int tweetCounts = 0;
        while (!maxHeap.isEmpty() && tweetCounts < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);
            tweetCounts++;
            if (t.next != null) {
                maxHeap.offer(t.next);
            }
        }

        return res;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    //Tweet link to next Tweet so that we can save a lot of time
    // when we execute getNewsFeed(userId)
    public class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public Tweet getNext() {
            return next;
        }

        public void setNext(Tweet next) {
            this.next = next;
        }
    }

    public class User {
        private int id;
        private Set<Integer> followed;
        private Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweetHead = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Set<Integer> getFollowed() {
            return followed;
        }

        public void setFollowed(Set<Integer> followed) {
            this.followed = followed;
        }

        public Tweet getTweetHead() {
            return tweetHead;
        }

        public void setTweetHead(Tweet tweetHead) {
            this.tweetHead = tweetHead;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        // add the tweet to the head
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }
}
