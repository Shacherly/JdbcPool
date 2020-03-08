package arithgram.binarytree;

/**
 * 打印二叉树
 */
public class TreePrinter {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();

        firstRoot(tree);
        // midRoot(tree);
    }

    public static void firstRoot(TreeNode root) {
        if (root == null) return;
        System.out.println(root.getVal());
        // 这是二叉树每一个节点都把自己当根节点的典型思维
        // 传根节点就完事了
        firstRoot(root.getLeft());
        firstRoot(root.getRight());
    }

    public static void midRoot(TreeNode root) {
        if (root == null) return;
        midRoot(root.getLeft());
        System.out.println(root.getVal());
        midRoot(root.getRight());
    }

    public static void lastRoot(TreeNode root) {
        if (root == null) return;
        lastRoot(root.getLeft());
        lastRoot(root.getRight());
        System.out.println(root.getVal());
    }


}
