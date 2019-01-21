package com.example.sys.controller.sys;

import com.example.base.common.tree.TreeNode;
import com.example.base.util.TreeUtils;
import com.example.sys.model.SysOrg;
import com.example.sys.service.sys.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping(value = "/get-tree")
    @ResponseBody
    public List<TreeNode> getTree(){
        List<SysOrg> orgs = sysOrgService.list();
        List<TreeNode> treeNodes = new ArrayList<>();
        for(SysOrg org : orgs){
            TreeNode node = new TreeNode();
            node.setId(org.getId());
            node.setPid(org.getParentId());
            node.setName(org.getName());
            treeNodes.add(node);
        }
        return TreeUtils.buildTree(treeNodes);
    }
}
