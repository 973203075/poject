package com.example.demo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        
//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
//        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
//        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
        System.out.println(userRepository.findByUserNameOrEmail("bb2", "cc@126.com").getNickName());
        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }

}