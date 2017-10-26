package com.coocaa.springBoot;

import com.coocaa.springBoot.domain.User;
import com.coocaa.springBoot.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findOneTest(){
        User user = userService.findOne(11);
        Assert.assertEquals(new Integer(9), user.getAge());
        System.out.println("冲突");
        System.out.println("冲突1");
        System.out.println("aaaaaaaaaaaa.......");
    }

}
