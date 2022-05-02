package com.twt.selfstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class IndexController {

    @RequestMapping("/*")
    String index(){
        return "index";
    }

}
