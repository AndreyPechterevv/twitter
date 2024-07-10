package myapp.twitter.user.tweet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import myapp.twitter.user.profile.model.UserProfile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Modifying;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(schema = "twitter", name = "tweets")
@EntityListeners(AuditingEntityListener.class)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createdTimestamp;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant modifiedTimestamp;


    @ManyToOne(optional = false)
    private UserProfile userProfile;
}
