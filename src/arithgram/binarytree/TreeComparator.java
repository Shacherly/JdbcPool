package arithgram.binarytree;

/**
 * 树的比较
 */
public class TreeComparator {

    /**
     * 完全相等比较
     */
    public static boolean compare(TreeNode a, TreeNode b) {
        // 防止两棵树的度不一样
        if (a == null && null != b || b == null && null != a) return false;
        if (a == null && b == null) return true;
        if (a.getVal() != b.getVal()) return false;
        return compare(a.getLeft(), b.getLeft()) && compare(a.getRight(), b.getRight());
    }

    /**
     * 允许镜像相等比较
     */
    public static boolean compare2(TreeNode a, TreeNode b) {
        // 防止两棵树的度不一样
        if (a == null && null != b || b == null && null != a) return false;
        if (a == null && b == null) return true;
        if (a.getVal() != b.getVal()) return false;
        // 很简单，无非就是左边和左边比右边和右边比；
        // 或者左边和右边比，右边和左边比
    return compare(a.getLeft(), b.getLeft())
            && compare(a.getRight(), b.getRight())
            || compare(a.getLeft(), b.getRight())
            && compare(a.getRight(), b.getLeft());
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        TreeNode tree1 = TreeNode.getTree1();
        System.out.println(compare(tree, tree1));
    }
}
