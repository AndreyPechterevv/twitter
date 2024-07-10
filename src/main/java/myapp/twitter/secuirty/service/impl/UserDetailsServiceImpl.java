package myapp.twitter.secuirty.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.model.UserAccount;
import myapp.twitter.secuirty.service.UserAccountService;
import myapp.twitter.secuirty.web.mappers.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        UserAccount userAccount = userAccountService.findUserByUsername(username);
        return new User(userAccount.getUsername(),userAccount.getPassword(),userAccount.getAuthorities());
    }
}
