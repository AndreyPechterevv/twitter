package myapp.twitter.user.subscription.repository;

import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.subscription.model.Subscription;
import myapp.twitter.user.subscription.service.impl.SubscriptionServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findSubscriptionByFollowerAndFollowed(UserProfile follower, UserProfile followed);
    boolean existsByFollowerAndFollowed(UserProfile follower, UserProfile followed);
}
