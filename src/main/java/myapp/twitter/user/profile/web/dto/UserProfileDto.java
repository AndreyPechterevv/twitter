package myapp.twitter.user.profile.web.dto;

import jakarta.validation.constraints.NotBlank;

public record UserProfileDto(
        @NotBlank(message = "nickname cant be null")
        String nickname,

        @NotBlank(message = "imageLink cant be null")
        String imageLink
) {
}
