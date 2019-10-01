package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.SignUp;

@Repository
public interface UserRegRepo extends JpaRepository<SignUp, String>{

}
