package myapp.twitter.user.subscription.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import myapp.twitter.user.profile.model.UserProfile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(schema = "twitter", name = "subscriptions")
@EntityListeners(AuditingEntityListener.class)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserProfile follower;

    @OneToOne
    private UserProfile followed;


    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createdTimestamp;

}