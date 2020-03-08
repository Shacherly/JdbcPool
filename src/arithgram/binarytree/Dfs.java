package arithgram.binarytree;

/**
 * 深度优先搜索
 */
public class Dfs {

public static boolean dfs(TreeNode root, int target) {
    if (root == null) return false;
    // 如过既不为空，根节点也不等于目标值
    if (root.getVal() == target) return true;
    // 那就看他的子树呗，递归！！！！
    return dfs(root.getLeft(), target) || dfs(root.getRight(), target);
}

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        System.out.println(dfs(tree, 8));

    }
}
