package com.example.base.util;

import com.example.base.common.tree.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeUtils {

    /**
     * 返回前端的树形结构，统一使用此数据结构，以空间换时间的方法，快速生成
     * 使用说明：
     * 1、需要将需要生成的数据统一先转换成 List<TreeNode> 结构，如果需要排序，则需要先把list排好序
     * 2、调用此方法
     * @param list
     * @return
     */
    public static List<TreeNode> buildTree(List<TreeNode> list){
        // 创建一个hash表，用来保存临时数据
        Map<Long, TreeNode> hashMap = new HashMap<>();
        // 将所有的节点保存到hash表中
        for(TreeNode current : list){
            hashMap.put(current.getId(), current);
        }
        // 生成树
        for(TreeNode current : list){
            if (current.getPid() != null){
                TreeNode parent = hashMap.get(current.getPid());
                if(parent != null){
                    if(!parent.isHasChild()){
                        parent.setHasChild(true);
                    }
                    parent.addChild(current);
                    hashMap.put(current.getPid(), parent);
                    hashMap.put(current.getId(), current);
                }
            }
        }
        // 获取根节点
        return hashMap.values().stream()
                .filter((TreeNode node) -> node.getPid() == null)
                .collect(Collectors.toList());
    }
}
