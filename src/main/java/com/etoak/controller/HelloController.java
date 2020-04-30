package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam(required = false,defaultValue = "world")String name,
                        Model model){
        //向request域赋值
        model.addAttribute("result","Hello"+name);
        return "hello";
    }
}
