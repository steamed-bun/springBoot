package com.coocaa.springBoot.service;

import com.coocaa.springBoot.domain.User;
import com.coocaa.springBoot.exception.UserException;
import com.coocaa.springBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void getAge(Integer id) throws Exception{

        User user = userRepository.findOne(id);
        Integer age = user.getAge();
        if (age < 10 ){
            throw new UserException("你已经是一个漂亮的蓝孩子啦...", 100);
        }else if (age > 10 && age < 20){
            throw new UserException("何不画上漂亮的眼影~...", 200);
        }
    }

}
