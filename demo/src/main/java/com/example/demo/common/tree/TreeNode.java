package com.example.demo.common.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private Long id;

    private Long parentId;

    private String name;

    private Integer type;

    private Boolean hasChild;

    private String code;

    List<TreeNode> children = new ArrayList<>();
}
