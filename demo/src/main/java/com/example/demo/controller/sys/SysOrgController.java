package com.example.demo.controller.sys;

import com.example.demo.model.SysOrg;
import com.example.demo.service.sys.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/org")
public class SysOrgController {

    private final SysOrgService sysOrgService;

    @Autowired
    public SysOrgController(SysOrgService sysOrgService) {
        this.sysOrgService = sysOrgService;
    }

    @GetMapping(value = "/get-list")
    @ResponseBody
    public List<SysOrg> getList() {
        return sysOrgService.list();
    }
}
