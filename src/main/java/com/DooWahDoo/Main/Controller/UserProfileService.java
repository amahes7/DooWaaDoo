package com.DooWahDoo.Main.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Repo.UserProfileRepo;

@Component
public class UserProfileService {

	@Autowired
	private Optional<UserProfile> userProfile;
	
	@Autowired
	private UserProfileRepo userProfileRepo;

	public Optional<UserProfile> getUserDetails(long userId) {
		userProfile = userProfileRepo.findById(userId);
		return userProfile;
	}

}
