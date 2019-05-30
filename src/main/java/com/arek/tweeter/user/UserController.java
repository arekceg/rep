package com.arek.tweeter.user;

import com.arek.tweeter.tweet.TweetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

	// == fields ==
	private TweetService tweetService;
	private UserService userService;

	// == get mappings ==

	@GetMapping("add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@GetMapping("all")
	public String showUserList(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user-list";
	}

	@GetMapping("{id}/tweets")
	public String getTweetsFromUserId(@PathVariable Long id,
	                                  Model model) {
		model.addAttribute("tweets", tweetService.getTweetsFromUserId(id));
		return "tweet-list";
	}

	@GetMapping("search-tweets/{string}")
	public String searchTweets(@PathVariable String string,
	                           Model model) {
		model.addAttribute("tweets", tweetService.getTweetsBeginningWithString(string));
		return "tweet-list";
	}

	@GetMapping("edit/{id}")
	public String getUserForEditing(@PathVariable Long id,
	                                Model model){
		model.addAttribute("user",userService.getUserById(id));
		return "user-form";
	}

	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable Long id){
		userService.deleteUserById(id);
		return "redirect:/user/all/";
	}

	// == post mappings ==

	@PostMapping("add")
	public String addUserFromForm(@ModelAttribute @Valid User user,
	                              BindingResult result) {
		if (result.hasErrors()) {
			return "user-form";
		}
		userService.addUser(user);
		return "redirect:/user/all";
	}

	@PostMapping("edit/{id}")
	public String editUser(@ModelAttribute @Valid User user,
	                              BindingResult result) {
		if (result.hasErrors()) {
			return "user-form";
		}
		userService.updateUser(user);
		return "redirect:/user/all";
	}
}
