package arithgram.binarytree;

// 二叉排序树
public class BinarySortingTree {

    private static int count = 0;

    public static TreeNode buildSortingTree(TreeNode root, TreeNode newNode) {
        if (root == null) return newNode;
        if (root.getVal() == newNode.getVal()) return root;
        if (newNode.getVal() < root.getVal())
            root.linkLeft(buildSortingTree(root.getLeft(), newNode));
        if (newNode.getVal() > root.getVal())
            root.linkRight(buildSortingTree(root.getRight(), newNode));
        return root;
    }

    public static boolean findTreeNode(TreeNode root, int target) {
        if (root == null) return false;
        if (root.getVal() == target) return true;
        // 找一次加一次
        count++;
        if (target < root.getVal()) return findTreeNode(root.getLeft(), target);
        return findTreeNode(root.getRight(), target);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        for (int i = 0; i < 10000000; i++) {
            int ran = (int) (Math.random() * 10000000);
            TreeNode node = new TreeNode(ran);
            root = buildSortingTree(root, node);
        }
        System.out.println("树的节点数：" + root.getSize());
        System.out.println("树的深度：" + TreeNode.getDepth(root));
        // System.out.println(root);
        long s1 = System.currentTimeMillis();
        System.out.println(s1);
        System.out.println("树中是否存在该节点：" + findTreeNode(root, 12300));
        long s2 = System.currentTimeMillis();
        System.out.println(s2);
        System.out.println("查找次数" + count);
        System.out.println("查找时间：" + (s2 - s1));
        int current = count;
        System.out.println("============");
        TreeNode newTree = TreeSpin.rotate(root);
        System.out.println("平衡树的深度：" + TreeNode.getDepth(newTree));
        long s3 = System.currentTimeMillis();
        System.out.println(s3);
        System.out.println("平衡树中是否存在该节点：" + findTreeNode(newTree, 12300));
        long s4 = System.currentTimeMillis();
        System.out.println(s4);
        System.out.println("平衡树查找次数" + (count - current));
        System.out.println("查找时间：" + (s4 - s3));

    }

}
