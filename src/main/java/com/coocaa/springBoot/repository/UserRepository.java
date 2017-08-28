package com.coocaa.springBoot.repository;

import com.coocaa.springBoot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findByAge(Integer age);

}
