package com.example.demo.controller;

import com.example.demo.controller.PropertyEditor.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat[] dateFormats = {
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"),
                new SimpleDateFormat("yyyy-mm-dd hh:mm"),
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("yyyy-MM"),
                new SimpleDateFormat("yyyy")
        };
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
