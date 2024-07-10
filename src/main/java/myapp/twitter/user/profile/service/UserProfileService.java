package myapp.twitter.user.profile.service;

import myapp.twitter.user.profile.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {

    UserProfile createUserProfile(UserProfile userProfile);

    UserProfile findUserProfileById(Long id);
}
