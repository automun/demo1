package com.example.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@RestController
public class 第二题 {

    @GetMapping(value ="/acc")
    public String Session1(String para , HttpSession session,
       @SessionAttribute(name = "para" ,required = false) String old_para)
    {
        if(old_para == null)
        {
            session.setAttribute("para","0");
            old_para = "0";
        }
            int a = Integer.parseInt(para);
            int b = Integer.parseInt(old_para);
            int c = a+b;
            String s = String.valueOf(c);
            session.setAttribute("para" ,s);
            return s;

    }
}
