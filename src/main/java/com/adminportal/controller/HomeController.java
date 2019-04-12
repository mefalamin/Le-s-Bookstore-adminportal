package com.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by saikat on 4/12/19
 */
@Controller
public class HomeController {

    @RequestMapping({"/","/index","/index.html"})
    public String home(){
        return "index";
    }

    @RequestMapping({"/login"})
    public String login(){
        return "login";
    }
}
