package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: demo
 * @description:
 * @author: WT1124
 * @create: 2019-02-01 14:18
 **/
@Controller
@RequestMapping("/")
public class RouteController {

    @RequestMapping("/")
    public String frame() {
        return "frame";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
