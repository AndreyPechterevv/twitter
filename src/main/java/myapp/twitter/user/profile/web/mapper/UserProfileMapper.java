package myapp.twitter.user.profile.web.mapper;

import myapp.twitter.secuirty.web.mappers.Mappable;
import myapp.twitter.user.profile.model.UserProfile;
import myapp.twitter.user.profile.web.dto.UserProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends Mappable<UserProfile, UserProfileDto> {
}
