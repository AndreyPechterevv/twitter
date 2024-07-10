package myapp.twitter.user.profile.repository;

import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    boolean existsByNickname(String nickname);


}
