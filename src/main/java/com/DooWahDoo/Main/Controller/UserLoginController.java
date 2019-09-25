package com.DooWahDoo.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Exception.ResourceNotFoundException;
import com.DooWahDoo.Main.Model.UserRegister;
import com.DooWahDoo.Main.Repo.UserRegRepo;

@RestController
@RequestMapping("/api/v1")
public class UserLoginController {
	@Autowired
	private UserRegRepo userRegRepo;

//	@PostMapping("/login")
//    public UserRegister createEmployee(@Valid @RequestBody UserRegister userRegister) {
////        return employeeRepository.save(employee);
//		return userRegRepo.save(userRegister);
//    }

//	@GetMapping(value="/hello", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String index() {
//
//        return "This is Home page";
//    }

	@GetMapping("/user/{email}")
	public String getUserFromEmail(@PathVariable(value = "email") String email) throws ResourceNotFoundException {
		List<UserRegister> users = userRegRepo.findAll();
		if (users.contains(email)) {
			return "Success";
		} else {
			return "Fail";
		}
	}

}
