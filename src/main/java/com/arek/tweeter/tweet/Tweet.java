package com.arek.tweeter.tweet;

import com.arek.tweeter.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tweeter_tweet")
@Data
@NoArgsConstructor
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Size(min = 5, max = 50)
	private String title;

	@NonNull
    @Size(max = 160)
	private String tweetText;

	private LocalDate created;

	@PrePersist
	public void prePersist(){
		created = LocalDate.now();
	}

	@ManyToOne
	private User user;
}