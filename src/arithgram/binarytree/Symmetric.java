package arithgram.binarytree;

import java.util.LinkedList;
import java.util.Queue;

// 对称二叉树，递归
public class Symmetric {

    public static void main(String[] args) {
        Integer[] arr = {1,2};
        TreeNode binaryTree = TreeNode.createBinaryTree(arr, 0);
        System.out.println();
        boolean symmetric = isSymmetric2(binaryTree);
        System.out.println(symmetric);
    }


    // 递归法
    public static boolean isSymmetric1(TreeNode root) {
        // 第一行必是严谨性判断
        if (root == null) return true;
        return isMirror(root.getLeft(), root.getRight());
    }

    // 迭代遍历法
    public static boolean isSymmetric2(TreeNode root) {
        // 第一行必是严谨性判断
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.getLeft());
        queue.add(root.getRight());

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();// 取出并移除，peek()取出但不移除
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            // 判断是否一侧为空
            if (node1 == null || node2 == null) return false;
            if (node1.getVal() != node2.getVal()) return false;

            queue.add(node1.getLeft());
            queue.add(node2.getRight());
            queue.add(node1.getRight());
            queue.add(node2.getLeft());
        }
        return true;
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        // 判断是否一侧为空
        if (node1 == null || node2 == null) return false;
        // 判断具体值是否相等
        if (node1.getVal() != node2.getVal()) return false;

        // 判断子树是否是镜像
        return isMirror(node1.getLeft(), node2.getRight())
                && isMirror(node1.getRight(), node2.getLeft());
    }

}
