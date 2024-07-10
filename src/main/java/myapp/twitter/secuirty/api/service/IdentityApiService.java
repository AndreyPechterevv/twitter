package myapp.twitter.secuirty.api.service;

import myapp.twitter.secuirty.api.model.CurrentUserApiModel;

public interface IdentityApiService {

    CurrentUserApiModel currentUserAccount();
}
