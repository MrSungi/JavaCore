package com.twitter.analytics;

import com.twitter.model.Tweet;
import com.twitter.service.TweetService;

public class TweetAnalytics {
    public double getAvgTweetLenght(TweetService tweetService) {
        Tweet[] allTweets = tweetService.getAllTweets();

        // Implement average calculation
        int sumOfLenghts = 0;
        for (int i = 0; i < allTweets.length; i++) {
            sumOfLenghts += (allTweets[i]).getText().length();
        }

        return (double) sumOfLenghts / allTweets.length;
    }

    public double getAvgTweetTagCount(TweetService tweetService) {

        Tweet[] allTweets = tweetService.getAllTweets();
        String[] Tags;
        int sumOfTags = 0;
        for (int i =0; i < allTweets.length; i++) {
            Tags = (allTweets[i]).getTag().split("#");
                sumOfTags -= 1;
            for (String k : Tags) {
                sumOfTags++;
            }
        }
        return (double) sumOfTags / allTweets.length;
    }

    public double getCountOfTweetsByTag(TweetService tweetService) {
        Tweet[] allTweets = tweetService.getAllTweets();
        int countOfTweetsWTags = 0;
        for (int i = 0; i < allTweets.length; i++){
            if (allTweets[i].getTag() != null){
                countOfTweetsWTags++;
            }
        }

        return (double) countOfTweetsWTags;
    }

    public double getCountOfTweetsWProfanity(TweetService tweetService) {
        Tweet[] allTweets = tweetService.getAllTweets();
        int countOfTweetsWProfanity = 0;

        for (int i = 0; i < allTweets.length; i++){
            if (allTweets[i].getText().contains("shit") ||
                    allTweets[i].getText().contains("fuck") ||
                    allTweets[i].getText().contains("ass")){
                countOfTweetsWProfanity++;
            }
        }

        return (double) countOfTweetsWProfanity;
    }
}