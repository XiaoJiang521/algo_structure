package algo.code.src.sort;

import util.MeterUtil;

/** 插入排序 */
public class InsertSelect {

    public static void insertSort(int arr[]) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                //                if (arr[j] > arr[j + 1]){
                MeterUtil.swap(arr, j, j + 1);
                //                }
            }
        }
    }
}
