package myapp.twitter.user.subscription.usecase;

import myapp.twitter.user.subscription.web.dto.SubscriptionRequest;

public interface SubscriptionAddUserCase {

    void subscribe(SubscriptionRequest subscriptionRequest);
}
