package myapp.twitter.secuirty.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.model.UserAccount;
import myapp.twitter.secuirty.model.UserRole;
import myapp.twitter.secuirty.repository.UserAccountRepository;
import myapp.twitter.secuirty.service.UserAccountService;
import myapp.twitter.secuirty.service.UserRoleService;
import myapp.twitter.secuirty.web.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserAccount create(UserAccount userAccount) {
        if (userAccountRepository.existsByUsername(userAccount.getUsername())) {
            throw new IllegalStateException("user account already exists");
        }
        UserRole userRole = userRoleService.findUserRole();
        userAccount.setAuthorities(Set.of(userRole));
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findUserByUsername(String username) {
        return userAccountRepository.findUserAccountByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("user account not found"));
    }
}
