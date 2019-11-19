package com.DooWahDoo.Main.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.SignUp;
import com.DooWahDoo.Main.Service.UserLoginService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserLoginController {
	
	
	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/login")
	public Map<String, Object> userLogin(@Valid @RequestBody SignUp signUp) {
		return userLoginService.getUser(signUp);
	}


}
