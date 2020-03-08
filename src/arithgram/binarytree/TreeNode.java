package arithgram.binarytree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 树的节点
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode linkLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode linkRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public static TreeNode getTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.linkLeft(node2).linkRight(node3);
        node2.linkLeft(node4).linkRight(node5);
        node3.linkRight(node6);

        return node1;
    }

    public static TreeNode getTree1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);

        node1.linkLeft(node2).linkRight(node3);
        node2.linkLeft(node4).linkRight(node5);
        node3.linkRight(node6);

        return node1;
    }
}
