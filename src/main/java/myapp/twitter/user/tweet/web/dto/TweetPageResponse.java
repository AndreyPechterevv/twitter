package myapp.twitter.user.tweet.web.dto;

import myapp.twitter.user.tweet.model.Tweet;

import java.util.Collection;

public record TweetPageResponse(
        Long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<TweetDto> tweets
) {
}
