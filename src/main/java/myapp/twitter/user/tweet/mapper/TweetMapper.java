package myapp.twitter.user.tweet.mapper;

import myapp.twitter.secuirty.web.mappers.Mappable;
import myapp.twitter.user.tweet.model.Tweet;
import myapp.twitter.user.tweet.web.dto.TweetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TweetMapper extends Mappable<Tweet, TweetDto> {

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdTimestamp", ignore = true)
//    Tweet toEntity(TweetDto tweetDto);

}
