package myapp.twitter.secuirty.web.mappers;

import myapp.twitter.secuirty.model.UserAccount;
import myapp.twitter.secuirty.web.dto.user.UserAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<UserAccount, UserAccountDto>{
}
