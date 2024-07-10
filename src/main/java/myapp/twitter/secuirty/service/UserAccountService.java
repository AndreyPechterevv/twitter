package myapp.twitter.secuirty.service;

import myapp.twitter.secuirty.model.UserAccount;

public interface UserAccountService {

    UserAccount create(UserAccount userAccount);

    UserAccount findUserByUsername(String username);

}
