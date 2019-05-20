package com.zyou.ops.util.tree;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.tree
 * @Author: yang
 * @CreateTime: 2019-05-17 17:32
 * @Description: ${Description}
 */

public class TreeNode implements Serializable {

    private String text;
    private List<TreeNode> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public TreeNode() {
    }

    public TreeNode(String text, List<TreeNode> nodes) {
        this.text = text;
        this.nodes = nodes;
    }
}
