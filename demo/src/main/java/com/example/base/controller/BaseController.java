package com.example.base.controller;

import com.example.base.controller.binder.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        String[] dateFormats = {"yyyy-mm-dd hh:mm:ss", "yyyy-mm-dd hh:mm", "yyyy-MM-dd", "yyyy-MM", "yyyy"};
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormats, true));
    }
}
