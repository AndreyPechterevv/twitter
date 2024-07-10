package myapp.twitter.secuirty.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.model.UserRole;
import myapp.twitter.secuirty.repository.UserRoleRepository;
import myapp.twitter.secuirty.service.UserRoleService;
import myapp.twitter.secuirty.web.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    @Override
    public UserRole findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER").orElseThrow(() -> new ResourceNotFoundException("userrole not found"));
    }
}
