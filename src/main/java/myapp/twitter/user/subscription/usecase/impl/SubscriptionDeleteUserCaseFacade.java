package myapp.twitter.user.subscription.usecase.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.web.exception.SubscriptionException;
import myapp.twitter.user.profile.api.UserProfileApiService;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.subscription.model.Subscription;
import myapp.twitter.user.subscription.service.SubscriptionService;
import myapp.twitter.user.subscription.usecase.SubscriptionDeleteUserCase;
import myapp.twitter.user.subscription.web.dto.SubscriptionRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionDeleteUserCaseFacade implements SubscriptionDeleteUserCase {

    private final SubscriptionService subscriptionService;
    private final UserProfileApiService userProfileApiService;

    @Override
    public void unsubscribe(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = new Subscription();
        UserProfile follower = userProfileApiService.currentUserProfile();
        UserProfile followed = userProfileApiService.findUserProfileById(subscriptionRequest.followedId());

        subscription.setFollower(follower);
        subscription.setFollowed(followed);
        if (follower.equals(followed)){
            throw new SubscriptionException("отписка от самого себя невозможна");
        }
        if (!subscriptionService.existsSubscription(subscription)) {
            throw new SubscriptionException("subscription doesnt exists");
        }

        subscriptionService.deleteSubscription(subscription);
    }
}
