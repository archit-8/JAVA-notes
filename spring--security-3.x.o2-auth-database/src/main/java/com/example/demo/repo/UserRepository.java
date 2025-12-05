package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MyUser;


@Repository
public interface UserRepository  extends JpaRepository<MyUser,Long>{
	Optional<MyUser> findByUsername(String username);

}
