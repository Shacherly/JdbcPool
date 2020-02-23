package arithgram;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr2 = {10, 2, 8, 1, 20, 50, 22, 11};
        mergeSort(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;// 永远只取中间数或者中间左边的数。
        if (left < right) {
            mergeSort(arr, left, mid);
            // 上面会一直执行到arr长度只有2在执行下面的
            mergeSort(arr, mid + 1, right);
            // 无限递归至长度只有2的时候调用下面的
            mergeSort(arr, left, mid, right);
        }
    }

    public static void mergeSort(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];// 创建临时数组长度为i到j
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }
        while (j <= right) {// 说明mid右边的已经全部放置完毕
            tmp[index++] = arr[j++];
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        // 我们把k左边的当做总是有序的，因为无限分割后左边只有一个肯定有序。
        if (tmp.length >= 0) System.arraycopy(tmp, 0, arr, left, tmp.length);
    }

}
