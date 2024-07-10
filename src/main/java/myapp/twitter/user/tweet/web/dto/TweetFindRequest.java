package myapp.twitter.user.tweet.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


public record TweetFindRequest(
        @Min(10)
        @Max(100)
        int limit,
        @Min(0)
        int page
) {
}
