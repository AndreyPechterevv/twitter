package myapp.twitter.user.subscription.web.dto;

import jakarta.validation.constraints.NotNull;

public record SubscriptionRequest
        (@NotNull Long followedId) {
}
