package myapp.twitter.user.profile.api;

import myapp.twitter.user.profile.model.UserProfile;

public interface UserProfileApiService {

    UserProfile currentUserProfile();
    UserProfile findUserProfileById(Long id);

}
