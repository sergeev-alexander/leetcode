package alexander.sergeev.leetcode.tasks;

import java.util.*;

// BEATS 90%
class a355 {

    /*
    Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
    and is able to see the 10 most recent tweets in the user's news feed.
    Implement the Twitter class:
    Twitter() Initializes your twitter object.
    void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
    Each call to this function will be made with a unique tweetId.
    List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
    Each item in the news feed must be posted by users who the user followed or by the user themself.
    Tweets must be ordered from most recent to least recent.
    void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
    void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
     */

    private final Map<Integer, TreeMap<Long, Integer>> postsMap;
    private final Map<Integer, Set<Integer>> friendshipMap;

    public a355() {
        postsMap = new HashMap<>();
        friendshipMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (postsMap.containsKey(userId)) {
            postsMap.get(userId).put(System.nanoTime(), tweetId);
        } else {
            TreeMap<Long, Integer> treeMap = new TreeMap<>();
            treeMap.put(System.nanoTime(), tweetId);
            postsMap.put(userId, treeMap);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        TreeMap<Long, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        if (postsMap.containsKey(userId)) {
            treeMap.putAll(postsMap.get(userId));
        }
        if (friendshipMap.containsKey(userId)) {
            for (int friend : friendshipMap.get(userId)) {
                if (postsMap.containsKey(friend)) {
                    treeMap.putAll(postsMap.get(friend));
                }
            }
        }
        return treeMap.values().stream()
                .limit(10)
                .toList();
    }

    public void follow(int followerId, int followeeId) {
        if (friendshipMap.containsKey(followerId)) {
            friendshipMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            friendshipMap.put(followerId, set);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (friendshipMap.containsKey(followerId)) {
            friendshipMap.get(followerId).remove(followeeId);
        }
    }
}