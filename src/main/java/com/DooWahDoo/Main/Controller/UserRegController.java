package com.DooWahDoo.Main.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.UserRegister;
import com.DooWahDoo.Main.Repo.UserRegRepo;
@RestController
@RequestMapping("/api/v1")
public class UserRegController {
	@Autowired
	private UserRegRepo userRegRepo;
	
	@PostMapping("/register")
    public UserRegister createEmployee(@Valid @RequestBody UserRegister userRegister) {
//        return employeeRepository.save(employee);
		return userRegRepo.save(userRegister);
    }

}
