package myapp.twitter.secuirty.web.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JwtRequest {


    @Email(message = "wrong type email")
    @NotBlank(message = "email must be not blank.")
    public String username;


    @NotBlank(message = "Password must be not blank.")
    public String password;
}