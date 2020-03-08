package arithgram.binarytree;

import java.util.Arrays;
import java.util.stream.Stream;

public class RestoreByQainZhong {

    public static TreeNode restore(int[] qian, int[] zhong) {
        if (qian == null || zhong == null || zhong.length == 0
                || qian.length != zhong.length) {
            return null;
        }
        // 从前序中找到根节点的
        TreeNode root = new TreeNode(qian[0]);
        // 从中序中由根节点划分左右子树
        int rootIdx = indexOf(zhong, root.getVal());
        // 找到左子树的前、中
        // 为什么是rootIdx + 1，举个例子
        // 前1, 2, 4, 5, 3, 6
        // 中4, 2, 5, 1, 3, 6
        // 两个对齐的话中序的根节点索引就是左子树的长度，长度+1就是to的索引，但不包含
        int[] leftQian = Arrays.copyOfRange(qian, 1, rootIdx + 1);
        int[] leftZhong = Arrays.copyOfRange(zhong, 0, rootIdx);
        // 构建左子树
        TreeNode left = restore(leftQian, leftZhong);

        // 找到右子树的前、中
        int[] rightQian = Arrays.copyOfRange(qian, rootIdx + 1, qian.length);
        int[] rightZhong = Arrays.copyOfRange(zhong, rootIdx + 1, zhong.length);
        // 构建右子树
        TreeNode right = restore(rightQian, rightZhong);
        return root.linkLeft(left).linkRight(right);
    }

    public static int indexOf(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] qian = new int[]{1, 2, 4, 5, 3, 6};
        int[] zhong = new int[]{4, 2, 5, 1, 3, 6};
        TreeNode restore = restore(qian, zhong);
        System.out.println(restore);
    }
}
