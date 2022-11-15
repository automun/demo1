package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/calc")
public class 第一题 {
    @GetMapping(value = "/")
    public String index()
    {
        return "form";
    }

    @GetMapping(value = "/sum1")
    @ResponseBody
        public String func1(String a,String b)
        {
            int c,d;
            c = Integer.parseInt(a);
            d = Integer.parseInt(b);
            int e = c+d;
            String s = String.valueOf(e);
            return s;
        }
    @GetMapping(value = "/sum12/{num1}/{num2}")
    @ResponseBody
    public String func2(@PathVariable String num1 ,@PathVariable String num2)
    {
        int a,b;
        a = Integer.parseInt(num1);
        b = Integer.parseInt(num2);
        int c = a+b;
        String s = String.valueOf(c);
        return s;
    }
    @PostMapping(value = "/sum3")
    @ResponseBody
    public String func3(HttpServletRequest request)
    {
        String a,b;
        a = request.getParameter("num1");
        b = request.getParameter("num2");
        int c = Integer.parseInt(a) + Integer.parseInt(b);
        String s = String.valueOf(c);
        return s;
    }
}
