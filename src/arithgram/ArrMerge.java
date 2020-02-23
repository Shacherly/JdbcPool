package arithgram;

import java.util.Arrays;

// 数组合并
public class ArrMerge {
    public static void main(String[] args) {
        int[] arr1 = {3,100};
        int[] arr2 = {2, 4, 6, 8, 10, 15, 17};
        int[] merge = merge(arr1, arr2);
        System.out.println(Arrays.toString(merge));


    }

    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return arr2;
        if (arr2 == null || arr2.length == 0) return arr1;
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0;
        int p2 = 0;
        int pr = 0;

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                result[pr++] = arr1[p1++];
            } else {
                result[pr++] = arr2[p2++];
            }
        }
        while (p1 == arr1.length && p2 != arr2.length) {
            result[pr++] = arr2[p2++];
            if (p2 > arr2.length) {
                break;
            }
        }
        while (p2 == arr2.length && p1 != arr1.length) {
            result[pr++] = arr1[p1++];
            if (p1 > arr1.length) {
                break;
            }
        }
        return result;
    }

}
