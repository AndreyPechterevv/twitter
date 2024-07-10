package myapp.twitter.user.subscription.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import myapp.twitter.user.subscription.usecase.SubscriptionAddUserCase;
import myapp.twitter.user.subscription.usecase.SubscriptionDeleteUserCase;
import myapp.twitter.user.subscription.web.dto.SubscriptionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionAddUserCase subscriptionAddUserCase;
    private final SubscriptionDeleteUserCase subscriptionDeleteUserCase;

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        subscriptionAddUserCase.subscribe(subscriptionRequest);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        subscriptionDeleteUserCase.unsubscribe(subscriptionRequest);
    }
}
