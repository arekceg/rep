package com.arek.tweeter.user;

import com.arek.tweeter.tweet.Tweet;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "tweeter_user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String fistName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

	@OneToMany
	private List<Tweet> tweets;

	@Transient
	private String fullName;

	public String getFullName() {
		return fistName + " " + lastName;
	}

}
