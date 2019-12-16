package com.twitter;

import com.twitter.analytics.TweetAnalytics;
import com.twitter.model.Tweet;
import com.twitter.service.TweetService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TweetAnalyticsTest {

    TweetAnalytics ta;

    @Before
    public void setUp() {
        ta = new TweetAnalytics();
    }

    @After
    public void tearDown() {
        ta = null;
    }

    @Test
    public void getAvgTweetLenght_givenManyTweets_calcsAvgCorrectly() {

        // given
        TweetService mockTweetService = mock(TweetService.class);

        Tweet[] allTweets = {
                new Tweet("Hello", "Mindaugas"),
                new Tweet("Bye Bye!", "Ignas"),
                new Tweet("Good bye cruel world!", "Johny John John")
        };

        when(mockTweetService.getAllTweets())
                .thenReturn(allTweets);

        // when
        double result = ta.getAvgTweetLenght(mockTweetService);

        // then
        Assert.assertEquals(11.36, result, 0.3);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void getAvgTagCount_givenManyTweets_calcsAvgCorrectly() {
        //given
        TweetService mockTweetService = mock(TweetService.class);

        Tweet[] allTweets = {
                new Tweet("Yepapa", "Petras", "#jonines #lauzas #jega #ko"),
                new Tweet("Yssepapa", "Petrasaa", "#jonines #lauzas #jega #kipisas"),
                new Tweet("epapa", "Pesaa", "#klipatra #jo #jega #kipisas"),
        };

        when(mockTweetService.getAllTweets())
                .thenReturn(allTweets);

        //when
        double result = ta.getAvgTweetTagCount(mockTweetService);

        //then
        Assert.assertEquals(4.0, result, 0);

    }
/////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void getTweetWTagCount_givenManyTweets_calcsTweetsCorrectly() {
        //given
        TweetService mockTweetService = mock(TweetService.class);

        Tweet[] allTweets = {
                new Tweet("Yepapa", "Petras", "#jonines #lauzas #jega #ko"),
                new Tweet("Yssepapa", "Petrasaa"),
                new Tweet("epapa", "Pesaa", "#klipatra #jo #jega #kipisas"),
        };

        when(mockTweetService.getAllTweets())
                .thenReturn(allTweets);

        //when
        double result = ta.getCountOfTweetsByTag(mockTweetService);

        //then
        Assert.assertEquals(2.0, result, 0);
    }
/////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void getTweetWProfanityCount_givenManyTweets_calcsTweetsCorrectly() {
        //given
        TweetService mockTweetService = mock(TweetService.class);

        Tweet[] allTweets = {
                new Tweet("Yepapa fuck", "Petras", "#jonines #lauzas #jega #ko"),
                new Tweet("Yssepapa", "Petrasaa"),
                new Tweet("epapa ass", "Pesaa", "#klipatra #jo #jega #kipisas"),
        };

        when(mockTweetService.getAllTweets())
                .thenReturn(allTweets);

        //when
        double result = ta.getCountOfTweetsWProfanity(mockTweetService);

        //then
        Assert.assertEquals(2.0, result, 0);
    }

}
