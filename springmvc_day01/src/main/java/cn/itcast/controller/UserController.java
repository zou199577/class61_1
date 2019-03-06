package cn.itcast.controller;


import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("findAll")
    public String findAllUsers(Model model){
        List<User> users = new ArrayList<>();
        for(int i= 0;i<10; i++){
            User user = new User();
            user.setUsername("张无忌"+(i+1));
            user.setAge(20+i);
            user.setIncome(10000.0+(100*i));
            user.setMarry(true);
            user.setHobby(new String[]{"看书", "打游戏", "学习"});
            users.add(user);


        }

        model.addAttribute("users",users);
        return "users";


    }
}
