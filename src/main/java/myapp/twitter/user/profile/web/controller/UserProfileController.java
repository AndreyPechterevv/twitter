package myapp.twitter.user.profile.web.controller;

import lombok.RequiredArgsConstructor;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.profile.service.UserProfileService;
import myapp.twitter.user.profile.web.dto.UserProfileDto;
import myapp.twitter.user.profile.web.mapper.UserProfileMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@RequestBody @Validated UserProfileDto dto) {
        UserProfile userProfile = userProfileMapper.toEntity(dto);
        userProfileService.createUserProfile(userProfile);
    }
}
