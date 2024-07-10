package myapp.twitter.user.subscription.usecase.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.web.exception.SubscriptionException;
import myapp.twitter.user.profile.api.UserProfileApiService;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.subscription.model.Subscription;
import myapp.twitter.user.subscription.service.SubscriptionService;
import myapp.twitter.user.subscription.usecase.SubscriptionAddUserCase;
import myapp.twitter.user.subscription.web.dto.SubscriptionRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionAddUserCaseFacade implements SubscriptionAddUserCase {

    private final SubscriptionService subscriptionService;
    private final UserProfileApiService userProfileApiService;

    @Override
    public void subscribe(SubscriptionRequest subscriptionRequest) {
        UserProfile follower = userProfileApiService.currentUserProfile();
        UserProfile followed = userProfileApiService.findUserProfileById(subscriptionRequest.followedId());

        Subscription subscription = new Subscription();
        subscription.setFollower(follower);
        subscription.setFollowed(followed);

        if (follower.equals(followed)) {
            throw new SubscriptionException("cant subscribe for yourself");
        }
        if (subscriptionService.existsSubscription(subscription)) {
            throw new SubscriptionException("subscription already exists");
        }

        subscriptionService.createSubscription(subscription);
    }
}
