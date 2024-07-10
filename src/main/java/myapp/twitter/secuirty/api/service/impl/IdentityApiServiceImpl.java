package myapp.twitter.secuirty.api.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.api.model.CurrentUserApiModel;
import myapp.twitter.secuirty.api.service.IdentityApiService;
import myapp.twitter.secuirty.model.UserAccount;
import myapp.twitter.secuirty.service.UserAccountService;
import myapp.twitter.secuirty.web.exception.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {

    private final UserAccountService userAccountService;
    @Override
    public CurrentUserApiModel currentUserAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            throw new AccessDeniedException("Access denied");
        }
        String name = authentication.getName();
        UserAccount userAccount = userAccountService.findUserByUsername(name);
        return new CurrentUserApiModel(userAccount.getId());
    }
}
