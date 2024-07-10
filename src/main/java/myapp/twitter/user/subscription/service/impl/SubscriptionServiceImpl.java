package myapp.twitter.user.subscription.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.user.subscription.model.Subscription;
import myapp.twitter.user.subscription.repository.SubscriptionRepository;
import myapp.twitter.user.subscription.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public void createSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Subscription subscription) {
        Subscription curSubscription = subscriptionRepository.findSubscriptionByFollowerAndFollowed(subscription.getFollower(), subscription.getFollowed());
        subscriptionRepository.delete(curSubscription);
    }

    @Override
    public boolean existsSubscription(Subscription subscription) {
        return subscriptionRepository.existsByFollowerAndFollowed(subscription.getFollower(), subscription.getFollowed());
    }
}
