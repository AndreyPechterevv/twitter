package myapp.twitter.user.profile.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "twitter", name = "user_profiles")
public class UserProfile {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String imageLink;

}
