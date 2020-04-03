package arithgram.binarytree;

import java.util.ArrayList;

/**
 * 广度优搜Breath First Search
 */
public class Bfs {

    /**
     * 广度优搜传入的而不是根节点，而是一个List，根节点集合
     * @param roots
     * @param target
     * @return
     */
    public static boolean bfs(ArrayList<TreeNode> roots, int target) {
        if (roots == null || roots.size() == 0) return false;

        ArrayList<TreeNode> childRoots = new ArrayList<>();
        for (TreeNode tree : roots) {
            //  如果存在立即返回，否则把当前节点的两个子节点放入集合
            if (tree.getVal() == target) return true;
            if (tree.getLeft() != null) childRoots.add(tree.getLeft());
            if (tree.getRight() != null) childRoots.add(tree.getRight());
        }
        return bfs(childRoots, target);
    }

    public static boolean bfs(TreeNode root, int target) {
        ArrayList<TreeNode> roots = new ArrayList<>();
        roots.add(root);
        return bfs(roots, target);
    }


    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        System.out.println(bfs(tree, 1));

    }
}
