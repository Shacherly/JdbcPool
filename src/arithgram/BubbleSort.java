package arithgram;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 7, 2, 9, 10, 23, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static boolean compare(int a, int b) {
        return a <= b;
    }

    public static void change(int[] arr, int idx1, int idx2) {
        arr[idx1] = arr[idx1] ^ arr[idx2];
        arr[idx2] = arr[idx1] ^ arr[idx2];
        arr[idx1] = arr[idx1] ^ arr[idx2];
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (compare(arr[j], arr[j + 1])) {
                    change(arr, j, j + 1);
                }
            }
        }
    }
}
