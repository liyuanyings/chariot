package com.example.sys;

import com.example.sys.service.sys.SysOrgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoTest {

    @Resource
    private SysOrgService sysOrgService;

    @Test
    public void testSelect() {

    }

}
