package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/lib")
public class 第三题 {
    @GetMapping(value = "/")
    public String login()
    {
        return "登录";
    }
    @PostMapping(value = "check")
    public String check(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("YongHu1") && password.equals("123456"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user" , "YongHu1");
            return "图书页";
        }
        else
        {
            return "登录";
        }
    }
    @GetMapping(value = "/load")
    public String load()
    {
        return "添加";
    }
    @PostMapping(value = "/load/add")
    @ResponseBody
    public String collector( HttpServletRequest request)
    {

        String Book,Author,date,num;
       // MultipartFile file = fr.getFile("img");
        Book = request.getParameter("BookName");
        Author = request.getParameter("author");
        date = request.getParameter("date1");
        num = request.getParameter("num");
        return " 书名："+Book+" 作者："+Author+" 日期："+date+" 余量"+num;
    }

}
