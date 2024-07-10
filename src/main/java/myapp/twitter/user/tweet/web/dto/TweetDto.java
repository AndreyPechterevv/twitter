package myapp.twitter.user.tweet.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import myapp.twitter.secuirty.web.dto.validation.OnCreate;
import myapp.twitter.secuirty.web.dto.validation.OnUpdate;

import java.time.Instant;

public record TweetDto(
        @NotNull(groups = OnUpdate.class)
        Long id,

        @Size(min = 10, max = 180, groups = {OnUpdate.class, OnCreate.class})
        String message,

        Instant createdTimestamp,
        Instant modifiedTimestamp
) {
}
