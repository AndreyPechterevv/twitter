package myapp.twitter.user.profile.api.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.api.service.IdentityApiService;
import myapp.twitter.user.profile.api.UserProfileApiService;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileApiServiceImpl implements UserProfileApiService {

    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    @Override
    public UserProfile findUserProfileById(Long id) {
        return userProfileService.findUserProfileById(id);
    }

    @Override
    public UserProfile currentUserProfile() {
        Long id = identityApiService.currentUserAccount().userAccountId();

        return userProfileService.findUserProfileById(id);

    }
}
