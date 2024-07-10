package myapp.twitter.secuirty.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import myapp.twitter.secuirty.web.dto.validation.OnCreate;
import myapp.twitter.secuirty.web.dto.validation.OnUpdate;

@ToString
@Getter
@Setter
public class UserAccountDto {


    @NotNull(
            message = "Id must be not null.",
            groups = OnUpdate.class
    )
    private Long id;


    @NotBlank(message = "email must be not null",groups = {OnCreate.class,OnUpdate.class})
    @Email(message = "bad email",groups = {OnCreate.class,OnUpdate.class})
    private String username;

    @JsonProperty(
            access = JsonProperty.Access.WRITE_ONLY
    )
    @NotNull(
            message = "Password must be not null.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String password;
}
