package algo.code.src.sort;

import util.MeterUtil;

public class HeapSort {

    /*
       从小到大排序 ，用大顶堆
    */
    public static void heapBigSort(int arr[]) {
        int N = arr.length;
        for (int i = N - 1; i >= 0; i--) {
            heapIfySmall(arr, i, N);
        }

        //        for (int i = 0; i < N; i++) {
        //            heapInsertSmall(arr ,i );
        //        }
        MeterUtil.swap(arr, 0, --N);
        while (N > 0) {
            heapIfySmall(arr, 0, N);
            MeterUtil.swap(arr, 0, --N);
        }
    }

    /*
       从大到小排序， 用小顶堆
    */
    public static void heapSmallSort(int arr[]) {
        int N = arr.length;
        //        for (int i = 0; i < N; i++) {
        //            heapIfyBig(arr ,i ,N );
        //        }

        for (int i = 0; i < N; i++) {
            heapInsertBig(arr, i);
        }

        MeterUtil.swap(arr, 0, --N);
        while (N > 0) {
            heapIfyBig(arr, 0, N);
            MeterUtil.swap(arr, 0, --N);
        }
    }

    /*
       index 的数字，插入到堆中 小顶堆
       insert 是从下往上
       直到index 的父节点，不比自己大(从小到大排序)，或者 0 位置 停止
    */
    public static void heapInsertSmall(int arr[], int index) {
        // index 不会为负数   除2 最小就是 0
        while (arr[index] < arr[(index - 1) / 2]) {
            MeterUtil.swap(arr, (index - 1) / 2, index);

            index = (index - 1) / 2;
        }
    }

    /*
       index 的数字 向下交换
       找出index 的left 和 right  中最小的 （从小到大排序）， 如果比index 的值小，
       那么index 就应该与他交换
    */
    public static void heapIfySmall(int arr[], int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int small = left + 1 < heapSize && arr[left] > arr[left + 1] ? left + 1 : left;
            if (arr[small] < arr[index]) {
                MeterUtil.swap(arr, small, index);
                index = small;
                left = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void heapInsertBig(int arr[], int index) {
        // index 不会为负数   除2 最小就是 0
        while (arr[index] > arr[(index - 1) / 2]) {
            MeterUtil.swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static void heapIfyBig(int arr[], int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int big = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            if (arr[big] > arr[index]) {
                MeterUtil.swap(arr, big, index);
                index = big;
                left = index * 2 + 1;
            } else {
                break;
            }
        }
    }
}
