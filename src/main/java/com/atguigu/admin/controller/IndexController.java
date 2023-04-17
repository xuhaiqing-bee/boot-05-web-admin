package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description
 * @date 2022/4/1 0001 17:07
 */
@Slf4j
@Controller
public class IndexController {
    /**
     * 去登录页
     * @return
     */
    @GetMapping(value = {"/","/index"})
    public String loginPage(){
//        model.addAttribute("msg","");

        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())){
            //登录成功，重定向到main页面
            session.setAttribute("loginUser",user);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","账号密码错误");
            //登录失败，返回到login页
            return "login";
        }

    }

    @GetMapping("/main")
    public String mainPage(HttpSession session,Model model){
          log.info("执行的方法是{}" + "mainPage");
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//            return "main";
//        }else {
//            model.addAttribute("msg","未登录，请登录");
//            return "login";
//        }
        return "main";
    }
}
