package myapp.twitter.secuirty.web.controller;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.model.UserAccount;
import myapp.twitter.secuirty.service.UserAccountService;
import myapp.twitter.secuirty.web.dto.auth.JwtRequest;
import myapp.twitter.secuirty.web.dto.user.UserAccountDto;
import myapp.twitter.secuirty.web.dto.validation.OnCreate;
import myapp.twitter.secuirty.web.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthUserController {

    private final UserAccountService userAccountService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public UserAccountDto register(@Validated(OnCreate.class) @RequestBody UserAccountDto dto) {
        UserAccount userAccount = userMapper.toEntity(dto);
        UserAccount createdUser = userAccountService.create(userAccount);
        return userMapper.toDto(createdUser);
    }
}
