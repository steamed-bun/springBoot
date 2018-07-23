package com.coocaa.springBoot.controller;

import com.coocaa.springBoot.domain.Result;
import com.coocaa.springBoot.domain.User;
import com.coocaa.springBoot.enums.GirlEnum;
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
    public void getAge(@PathVariable("id") Integer id, String test) throws Exception{
        System.out.println(test);
            userService.getAge(id);
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    /**
     * 可以进行 JSR-303 验证的测试
     * @param user 注册用户
     * @param bindingResult 验证参数结果,此参数不能少
     * @return result
     */
    @RequestMapping(value = "addUser")
    public Result addUser(@Valid User user, BindingResult bindingResult){
        System.out.println(user);
        return ResultUtil.success(GirlEnum.SUCCESS,userRepository.save(user));
    }

    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return null;
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
    }

    @GetMapping(value = "/getUserByAge/{age}")
    public List<User> getUserByAge(@PathVariable("age") Integer age){
        return userRepository.findByAge(age);
    }

}
