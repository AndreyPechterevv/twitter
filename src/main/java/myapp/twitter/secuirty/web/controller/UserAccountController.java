package myapp.twitter.secuirty.web.controller;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.model.UserAccount;
import myapp.twitter.secuirty.model.UserRole;
import myapp.twitter.secuirty.service.UserAccountService;
import myapp.twitter.secuirty.service.UserRoleService;
import myapp.twitter.secuirty.web.dto.auth.JwtRequest;
import myapp.twitter.secuirty.web.dto.user.UserAccountDto;
import myapp.twitter.secuirty.web.dto.validation.OnCreate;
import myapp.twitter.secuirty.web.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserRoleService userRoleService;
    private final UserMapper userMapper;

//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public UserAccountDto register( @RequestBody UserAccountDto dto) {
//        UserAccount userAccount = userMapper.toEntity(dto);
//        UserAccount createdUser = userAccountService.create(userAccount);
//        return userMapper.toDto(createdUser);
//    }

}
