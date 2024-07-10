package myapp.twitter.user.tweet.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.web.exception.AccessDeniedException;
import myapp.twitter.secuirty.web.exception.ResourceNotFoundException;
import myapp.twitter.user.profile.api.UserProfileApiService;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.tweet.mapper.TweetMapper;
import myapp.twitter.user.tweet.model.Tweet;
import myapp.twitter.user.tweet.repository.TweetRepository;
import myapp.twitter.user.tweet.service.TweetService;
import myapp.twitter.user.tweet.web.dto.TweetDto;
import myapp.twitter.user.tweet.web.dto.TweetFindRequest;
import myapp.twitter.user.tweet.web.dto.TweetPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;
    private final UserProfileApiService currentUserProfileApiService;
    private final TweetMapper tweetMapper;

    @Override
    public Tweet updateTweet(Tweet tweet) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = findTweetById(tweet.getId()).getUserProfile();
        if (!actor.equals(owner)) {
            throw new AccessDeniedException("denied to edit tweet to not owner");
        }
        Tweet curTweet = findTweetById(tweet.getId());
        curTweet.setMessage(tweet.getMessage());
        return tweetRepository.save(curTweet);
    }

    @Override
    public Page<Tweet> findTweets(TweetFindRequest tweetFindRequest) {
        UserProfile owner = currentUserProfileApiService.currentUserProfile();
        Sort sort = Sort.by(Sort.Direction.DESC, "createdTimestamp");
        Pageable pageable = PageRequest.of(tweetFindRequest.page(), tweetFindRequest.limit(), sort);
        return tweetRepository.findTweetsByUserProfile(owner, pageable);
    }

    @Override
    public void deleteTweetById(Long id) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = findTweetById(id).getUserProfile();
        if (!actor.equals(owner)) {
            throw new AccessDeniedException("denied to delete tweet to not owner");
        }
        tweetRepository.deleteById(id);
    }

    @Override
    public Tweet findTweetById(Long id) {
        return tweetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tweet not found"));
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        tweet.setUserProfile(currentUserProfileApiService.currentUserProfile());
        return tweetRepository.save(tweet);
    }

    @Override
    public TweetPageResponse findTweetsResponse(TweetFindRequest tweetFindRequest) {
        Page<Tweet> tweets = findTweets(tweetFindRequest);
        Collection<TweetDto> tweetsDto = tweets.stream()
                .map(tweetMapper::toDto)
                .toList();

        return new TweetPageResponse(
                tweets.getTotalElements(),
                tweets.isFirst(),
                tweets.isLast(),
                tweetsDto);
    }
}
