package algo.code.src.sort;

import util.MeterUtil;

public class SelectSort {
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            MeterUtil.swap(arr, minIndex, i);
        }
    }
}
