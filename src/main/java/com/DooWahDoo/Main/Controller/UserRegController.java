package com.DooWahDoo.Main.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.SignUp;
import com.DooWahDoo.Main.Model.SignUpProfileWrapper;
import com.DooWahDoo.Main.Repo.UserRegRepo;
import com.DooWahDoo.Main.Service.UserRegisterService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserRegController {
	@Autowired
	private UserRegRepo userRegRepo;


	@Autowired
	private UserRegisterService userRegisterService;
	
	@PostMapping("/RegisterUser")
//   public SignUp createEmployee(@Valid @RequestBody SignUp signUp) {
	public SignUp createUser(@Valid @RequestBody SignUpProfileWrapper signUpProfileWrapper) {
		return userRegisterService.createUser(signUpProfileWrapper);
	}

	@GetMapping("/test")
	public String test() {
		return "I'm running";
	}

	@PostMapping("/login")
	public Map<String, Object> userLogin(@Valid @RequestBody SignUp signUp) {
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
