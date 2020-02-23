package arithgram;

import java.util.Arrays;

// 选择排序
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 7, 2, 9, 10, 23, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static boolean compare(int a, int b) {
        return a > b;
    }

    public static void change(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void sort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int maxIdx = 0;
            for (int i = 0; i < arr.length - j; i++) {
                if (compare(arr[i], arr[maxIdx])) {
                    maxIdx = i;
                }
            }
            change(arr, maxIdx, arr.length - 1 - j);
        }

    }


}
