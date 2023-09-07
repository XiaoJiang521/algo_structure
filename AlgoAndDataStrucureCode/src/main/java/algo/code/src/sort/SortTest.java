package algo.code.src.sort;

import algo.code.src.util.MeterUtil;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int minLen = 10;
        int numMax = 20;
        boolean judge = true;
        for (int i = 0; i < 1000; i++) {
            int[] arr = MeterUtil.getArr(minLen, numMax, true);
            int[] arrCopy = MeterUtil.copyArr(arr);
            Arrays.sort(arr);
            //            BubbleSort.bubbleSort(arrCopy);
            //            InsertSelect.insertSort(arrCopy);
            //            SelectSort.selectSort(arrCopy);
            //            QuickSort.quickSortStrength(arrCopy);
            HeapSort.heapSmallSort(arrCopy);

            if (!MeterUtil.judge(arr, arrCopy)) {
                judge = false;
                MeterUtil.printArr(arr);
                MeterUtil.printArr(arrCopy);
                break;
            }
        }
        if (judge) {
            System.out.println(" no problem ");
        }
    }
}
