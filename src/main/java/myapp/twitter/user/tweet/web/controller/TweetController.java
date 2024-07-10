package myapp.twitter.user.tweet.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.web.dto.validation.OnCreate;
import myapp.twitter.secuirty.web.dto.validation.OnUpdate;
import myapp.twitter.user.tweet.mapper.TweetMapper;
import myapp.twitter.user.tweet.model.Tweet;
import myapp.twitter.user.tweet.service.TweetService;
import myapp.twitter.user.tweet.web.dto.TweetDto;
import myapp.twitter.user.tweet.web.dto.TweetFindRequest;
import myapp.twitter.user.tweet.web.dto.TweetPageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetService tweetService;
    private final TweetMapper tweetMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetDto createTweet(@Validated(OnCreate.class) @RequestBody TweetDto tweetDto) {
        Tweet tweet = tweetMapper.toEntity(tweetDto);
        Tweet createdTweet = tweetService.createTweet(tweet);
        return tweetMapper.toDto(createdTweet);
    }

    @GetMapping
    public TweetPageResponse findAllTweets(@PathParam("page") int page, @PathParam("limit") int limit) {
        TweetFindRequest tweetFindRequest = new TweetFindRequest(limit, page);
        return tweetService.findTweetsResponse(tweetFindRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTweet(@PathVariable("id") Long id) {
        tweetService.deleteTweetById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TweetDto updateTweet(@Validated(OnUpdate.class) @RequestBody TweetDto tweetDto) {
        Tweet tweet = tweetMapper.toEntity(tweetDto);
        Tweet createdTweet = tweetService.updateTweet(tweet);
        return tweetMapper.toDto(createdTweet);
    }
}
