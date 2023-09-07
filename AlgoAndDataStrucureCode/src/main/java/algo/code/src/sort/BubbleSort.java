package algo.code.src.sort;

import util.MeterUtil;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    MeterUtil.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
