package arithgram.binarytree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 树的节点
 */
@Getter
// @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private int size;
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    // 链到左子树
    public TreeNode linkLeft(TreeNode left) {
        this.left = left;
        size++;
        return this;
    }

    // 链到右子树
    public TreeNode linkRight(TreeNode right) {
        this.right = right;
        size++;
        return this;
    }

    // 获取树的深度
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.getLeft());
        int rightDepth = getDepth(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 判断是否平衡
    public static boolean bananced(TreeNode root) {
        if (root == null) return true;
        int leftDe = TreeNode.getDepth(root.getLeft());
        int rightDe = TreeNode.getDepth(root.getRight());
        if (Math.abs(leftDe - rightDe) > 1) return false;
        // 把每一个节点都当做根节点
        return bananced(root.getLeft()) && bananced(root.getRight());
    }

    public boolean needLeftRotate() {
        return getDepth(this.getRight()) - getDepth(this.getLeft()) > 1;
    }

    public boolean needRightRotate() {
        return getDepth(this.getLeft()) - getDepth(this.getRight()) > 1;
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

    public static TreeNode getTree2() {

        TreeNode node4 = new TreeNode(40);
        TreeNode node5 = new TreeNode(50);
        TreeNode node6 = new TreeNode(60);
        TreeNode node7 = new TreeNode(70);
        TreeNode node8 = new TreeNode(80);
        TreeNode node9 = new TreeNode(90);

        node9.linkLeft(node6);
        node6.linkLeft(node5).linkRight(node7);
        node5.linkLeft(node4);
        node7.linkRight(node8);

        return node9;
    }
}
