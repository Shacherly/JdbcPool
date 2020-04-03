package arithgram.binarytree;

// 二叉排序树
public class SortedBinaryTree {

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
        // 找一次加一次
        count++;// count++之所以没有放在第一行，是因为如果传进来node为null这一次是算数的，上一次才算
        if (root.getVal() == target) return true;
        if (target < root.getVal()) return findTreeNode(root.getLeft(), target);
        return findTreeNode(root.getRight(), target);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        System.out.println("正在构建二叉排序树……");
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int ran = (int) (Math.random() * 1000000);
            TreeNode node = new TreeNode(ran);
            root = buildSortingTree(root, node);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("构建耗时：" + (s2 - s1) / 1000);
        System.out.println("总节点数：" + root.getSize());
        System.out.println("树的深度：" + TreeNode.getDepth(root));
        // System.out.println(root);

        // System.out.println(s1);
        System.out.println("查找树中是否存在该节点：" + findTreeNode(root, 12300));

        // System.out.println(s2);
        System.out.println("查找次数" + count);
        // System.out.println("查找时间：" + (s2 - s1));
        int current = count;
        System.out.println("========================");
        System.out.println("二叉排序树单旋，构建二叉平衡排序树……");
        long s3 = System.currentTimeMillis();
        TreeNode newTree = BalancedSortedBinaryTree.rotate(root);
        long s4 = System.currentTimeMillis();
        System.out.println("构建平衡树耗时：" + (s4 - s3) / 1000);
        System.out.println("平衡树的深度：" + TreeNode.getDepth(newTree));

        // System.out.println(s3);
        System.out.println("平衡树中是否存在该节点：" + findTreeNode(newTree, 12300));

        // System.out.println(s4);
        System.out.println("平衡树查找次数" + (count - current));


    }

}
