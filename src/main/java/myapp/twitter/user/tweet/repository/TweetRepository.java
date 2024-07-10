package myapp.twitter.user.tweet.repository;

import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Page<Tweet> findTweetsByUserProfile(UserProfile userProfile, Pageable pageable);

}
