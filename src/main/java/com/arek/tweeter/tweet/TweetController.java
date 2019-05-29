package com.arek.tweeter.tweet;

import com.arek.tweeter.user.User;
import com.arek.tweeter.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("tweet")
@AllArgsConstructor
public class TweetController {

	// == fields ==
	private TweetService tweetService;
	private UserService userService;

	// == model attributes ==
	@ModelAttribute("users")
	public List<User> allUsers() {
		return userService.getAllUsers();
	}

	// == get mappings ==
	@GetMapping("all")
	public String showTweetList(Model model) {
		model.addAttribute("tweets", tweetService.getAllTweets());
		return "tweet-list";
	}

	@GetMapping("add")
	public String addTweet(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "tweet-form";
	}

	// == post mapping ==
	@PostMapping("add")
	public String addTweetFromForm(@ModelAttribute @Valid Tweet tweet,
	                              BindingResult result) {
		if (result.hasErrors()) {
			return "tweet-form";
		}
        tweetService.addTweet(tweet);
		return "redirect:/tweet/all";
	}
}
