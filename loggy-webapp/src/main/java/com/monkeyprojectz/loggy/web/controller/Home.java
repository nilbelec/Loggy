package com.monkeyprojectz.loggy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class Home {

    @RequestMapping
    public String getIndex(){
        return "index";
    }
}
