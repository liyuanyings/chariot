package com.example.base.common.tree;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class TreeNode {

    private Long id;

    private Long pid;

    private String name;

    private String code;

    private String type;

    private boolean hasChild = false;

    List<TreeNode> children = new ArrayList<>();

    public void addChild(TreeNode node){
        this.children.add(node);
    }
}