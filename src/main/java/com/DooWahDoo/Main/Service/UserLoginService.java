package com.DooWahDoo.Main.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Model.SignUp;
import com.DooWahDoo.Main.Repo.UserRegRepo;

@Component
public class UserLoginService {

	@Autowired
	private UserRegRepo userRegRepo;

	public Map<String, Object> getUser(@Valid SignUp signUp) {
		Optional<SignUp> user = userRegRepo.findById(signUp.getEmailId());
		Map<String, Object> result = new HashMap<>();
		if (user.isPresent()) {
			if (user.get().getPassword().equals(signUp.getPassword())) {
				result.put("Status", "Success");
				result.put("userInfo", user);
			} else {
				result.put("Status", "Wrong Password");
				result.put("userInfo", null);
			}

		} else {
			result.put("Status", "No such user");
			result.put("userInfo", null);
		}
		return result;
	}

}
