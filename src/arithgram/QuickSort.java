package arithgram;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 6, 3, 1, 19, 14, 17, 12};
        partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // public static void quickSort(int[] arr, int low, int high) {
    //     if (low < high) {
    //         partition(arr, low, high)
    //     }
    // }

    public static void partition(int[] arr, int headIdx, int tailIdx) {
        if (headIdx < tailIdx) {
            int leader = arr[headIdx];
            int i = headIdx;
            int j = tailIdx;
            while (i < j) {
                while (i < j && arr[j] >= leader) j--;
                arr[i] = arr[j];
                while(i < j && arr[i] <= leader) i++;
                arr[j] = arr[i];
            }
            arr[i] = leader;
            partition(arr, headIdx, i);
            partition(arr, i + 1, tailIdx);
        }
    }
}
