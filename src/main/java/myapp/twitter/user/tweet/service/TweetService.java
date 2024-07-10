package myapp.twitter.user.tweet.service;

import jakarta.validation.Valid;
import myapp.twitter.user.tweet.model.Tweet;
import myapp.twitter.user.tweet.web.dto.TweetFindRequest;
import myapp.twitter.user.tweet.web.dto.TweetPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;

@Validated
public interface TweetService {

    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Tweet findTweetById(Long id);

    Page<Tweet> findTweets(@Valid TweetFindRequest tweetFindRequest);

    void deleteTweetById(Long id);

    TweetPageResponse findTweetsResponse(@Valid TweetFindRequest tweetFindRequest);
}
