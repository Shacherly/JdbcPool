package arithgram.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public static void main(String[] args) {
        Integer[] arr = {4, 2, 7, 1, 3, 6, 9};
        TreeNode binaryTree = TreeNode.createBinaryTree(arr, 0);
        System.out.println();
        TreeNode invert = invert(binaryTree);
        System.out.println();
    }

    public static TreeNode invert(TreeNode root) {
        // 严谨性判断，其实是递归的出口
        if (root == null) return null;
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invert(root.left);
        invert(root.right);
        return root;
    }

    public static TreeNode invert1(TreeNode root) {
        if(root == null) return null;

        invert1(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert1(root.left);
        return root;

    }

    // 后序
    public static TreeNode invert2(TreeNode root) {
        if(root == null) return null;

        invert1(root.left);
        invert1(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;

    }

    public static TreeNode invertByBreath(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        // offer也可以添加，不同在于add如果加满了会报错，但是offer会返回false，更多使用offer
        queue.offer(root.getLeft());
        queue.offer(root.getRight());

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
