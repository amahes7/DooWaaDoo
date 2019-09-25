package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.DooWahDoo.Main.Model.UserRegister;

@Repository
public interface UserRegRepo extends JpaRepository<UserRegister, Integer>{

}
