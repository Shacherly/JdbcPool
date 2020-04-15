package arithgram.binarytree;

/**
 * 深度优先搜索
 * 深搜其实也分前中后序
 */
public class Dfs {

    // 前序，也就是根--左--右
    public static boolean dfs(TreeNode root, int target) {
        if (root == null) return false;
        System.out.println(root.getVal());
        // 如果既不为空，根节点也不等于目标值
        if (root.getVal() == target) return true;
        // 那就看他的子树呗，递归！！！！
        return dfs(root.getLeft(), target) || dfs(root.getRight(), target);
    }

    // 中序，左--根--右
    public static boolean dfs1(TreeNode root, int target) {
        if (root == null) return false;
        // 放这里的输出顺序就是前序的？？？
        // System.out.println(root.getVal());
        if (dfs1(root.getLeft(), target)) return true;
        // 但是放这里的输出顺序却是中序的？？？？
        // System.out.println(root.getVal());
        // 如果既不为空，根节点也不等于目标值
        if (root.getVal() == target) return true;
        System.out.println(root.getVal());
        return dfs1(root.getRight(), target);
    }


    public static boolean dfs2(TreeNode root, int target) {
        if (root == null) return false;
        // 如果为false则一直递归，因此递归方法的返回值实际山给了上一次if用于判断是否继续递归
        if (dfs2(root.getLeft(), target)) return true;

        if (dfs2(root.getRight(), target)) return true;
        System.out.println(root.getVal());
        return root.getVal() == target;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        System.out.println(dfs2(tree, 10));

    }
}
