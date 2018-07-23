package com.coocaa.springBoot.service;

import com.coocaa.springBoot.domain.User;
import com.coocaa.springBoot.enums.GirlEnum;
import com.coocaa.springBoot.enums.ResultEnum;
import com.coocaa.springBoot.exception.UserException;
import com.coocaa.springBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void getAge(Integer id) throws Exception{

        User user = new User();
        Integer age = user.getAge();
        if (age < 10 ){
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 20){
            throw new UserException(GirlEnum.MIDDLE_SCHOOL);
        }
    }

    public User findOne(Integer id){
        return null;
    }

}
