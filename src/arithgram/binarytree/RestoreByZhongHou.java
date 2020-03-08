package arithgram.binarytree;

import java.util.Arrays;

public class RestoreByZhongHou {

    public static TreeNode restore(int[] zhong, int[] hou) {
        if (zhong == null || hou == null || hou.length == 0
                || zhong.length != hou.length) {
            return null;
        }
        // 从后序中找到根节点，也就是最后一个
        TreeNode root = new TreeNode(hou[hou.length - 1]);
        // 从中序中由根节点划分左右子树
        int rootIdx = indexOf(zhong, root.getVal());
        // 找到左子树的中、后
        // 两个对齐的话中序的根节点索引就是左子树的长度，长度+1就是to的索引，但不包含
        int[] leftZhong = Arrays.copyOfRange(zhong, 0, rootIdx);
        int[] leftHou = Arrays.copyOfRange(hou, 0, rootIdx);
        // 构建左子树
        TreeNode left = restore(leftZhong, leftHou);

        // 找到右子树的中、后
        int[] rightZhong = Arrays.copyOfRange(zhong, rootIdx + 1, zhong.length);
        int[] rightHou = Arrays.copyOfRange(hou, rootIdx, hou.length - 1);

        // 构建右子树
        TreeNode right = restore(rightZhong, rightHou);
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
        // int[] qian = new int[]{1, 2, 4, 5, 3, 6};
        int[] zhong = new int[]{4, 2, 5, 1, 3, 6};
        int[] hou = new int[]{4, 5,2, 6, 3, 1};
        TreeNode restore = restore(zhong, hou);
        System.out.println(restore);
    }
}
