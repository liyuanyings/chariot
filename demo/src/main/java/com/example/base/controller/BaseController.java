package com.example.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    protected <T> IPage<T> getPage(long pageNumber, long pageSize) {
        return new Page<>(pageNumber, pageSize);
    }
}
