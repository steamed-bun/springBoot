package com.coocaa.springBoot.controller;

import com.coocaa.springBoot.domain.Result;
import com.coocaa.springBoot.domain.User;
import com.coocaa.springBoot.repository.UserRepository;
import com.coocaa.springBoot.service.UserService;
import com.coocaa.springBoot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
            userService.getAge(id);
    }



    @GetMapping(value = "/test1")
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "addUser")
    public Result addUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(userRepository.save(user));
    }

    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.findOne(id);
    }

    @PutMapping(value = "/updateUser/{id}")
    public User updateUser(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           @RequestParam("money") Float money){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setMoney(money);
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.delete(id);
    }

    @GetMapping(value = "/getUserByAge/{age}")
    public List<User> getUserByAge(@PathVariable("age") Integer age){
        return userRepository.findByAge(age);
    }

}
