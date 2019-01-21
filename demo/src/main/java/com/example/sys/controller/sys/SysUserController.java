package com.example.sys.controller.sys;

import com.example.sys.model.SysOrg;
import com.example.sys.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    private final SysUserService SysUserService;

    @Autowired
    public SysUserController(SysUserService SysUserService) {
        this.SysUserService = SysUserService;
    }

    @GetMapping(value = "/get-list")
    public List<SysOrg> getList() {
        return null;
    }


}
