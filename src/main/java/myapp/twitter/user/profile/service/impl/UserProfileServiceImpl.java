package myapp.twitter.user.profile.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.api.service.IdentityApiService;
import myapp.twitter.secuirty.web.exception.ResourceNotFoundException;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.profile.repository.UserProfileRepository;
import myapp.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final IdentityApiService identityApiService;

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        userProfile.setId(identityApiService.currentUserAccount().userAccountId());
        if (userProfileRepository.existsById(userProfile.getId())) {
            throw new IllegalStateException("this profile is existed");
        }
        if (userProfileRepository.existsByNickname(userProfile.getNickname())){
            throw new IllegalStateException("this nickname is existed");
        }
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findUserProfileById(Long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Данный профиль не сущетсвует"));
    }
}
