package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.exception.UserManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description
 * @date 2023/4/5 0005 12:16
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("张三", "12"), new User("李四", "12"));
        model.addAttribute("users",users);

        if (users.size() > 1){
            throw new UserManyException();
        }
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

}
