package arithgram.binarytree;

// 二叉树单旋，转成平衡二叉树
public class BalancedSortedBinaryTree {

    // 得从最末端开始判断
    public static TreeNode rotate(TreeNode root) {
        if (root == null) return null;
        // 怎么从最末端开始？我上来就递归传入子节点
        root.linkLeft(rotate(root.getLeft()));
        root.linkRight(rotate(root.getRight()));
        int leftDe = TreeNode.getDepth(root.getLeft());
        int rightDe = TreeNode.getDepth(root.getRight());
        if (leftDe + 1 < rightDe) {
            // System.out.println("左边浅，左旋：" + root.getVal());
            int rld = TreeNode.getDepth(root.getRight().getLeft());// 变分支
            int rrd = TreeNode.getDepth(root.getRight().getRight());
            if (rld > rrd) root.linkRight(rightRotate(root.getRight()));// 先右单旋
            root = leftRotate(root);
            root.linkLeft(root.getLeft());
        }
        if (rightDe + 1 < leftDe) {
            // System.out.println("右边浅，右旋：" + root.getVal());
            int lld = TreeNode.getDepth(root.getLeft().getLeft());
            int lrd = TreeNode.getDepth(root.getLeft().getRight());// 变分支
            if (lrd > lld) root.linkLeft(leftRotate(root.getLeft()));// 先左单旋
            root = rightRotate(root);// 右旋之后可能还要右旋
            root.linkRight(rotate(root.getRight()));
        }
        return root;
    }

    //左单旋
    public static TreeNode leftRotate(TreeNode root) {
        TreeNode oldRoot = root;// 原根
        TreeNode newRoot = root.getRight();// 新根
        TreeNode changingRoot = newRoot.getLeft();// 变化分支
        newRoot.linkLeft(oldRoot);
        oldRoot.linkRight(changingRoot);
        return newRoot;
    }

    // 右单旋
    public static TreeNode rightRotate(TreeNode root) {
        TreeNode oldRoot = root;// 原根
        TreeNode newRoot = root.getLeft();// 新根
        TreeNode changingRoot = newRoot.getRight();
        newRoot.linkRight(oldRoot);
        oldRoot.linkLeft(changingRoot);
        return newRoot;
    }


    // public static void leftSpin
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree2();
        System.out.println(TreeNode.getDepth(tree));
        System.out.println(TreeNode.bananced(tree));

        System.out.println("");
        TreeNode result = rotate(tree);
        System.out.println(TreeNode.bananced(result));
        System.out.println(TreeNode.getDepth(result));
        System.out.println(TreeNode.depth(result));
    }




}
