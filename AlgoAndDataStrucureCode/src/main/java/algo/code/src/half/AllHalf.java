package algo.code.src.half;

import util.MeterUtil;

import java.util.Arrays;

/** 二分法 */
public class AllHalf {
    public static void main(String[] args) {
        int arrLen = 30;
        int numMax = 7;
        for (int i = 0; i < 10; i++) {
            //            int[] arr = MeterUtil.getArrNoRepetition(arrLen, numMax, true);
            int[] arr = MeterUtil.getArr(arrLen, numMax, true);
            Arrays.sort(arr);
            MeterUtil.printArr(arr);
            int rangeNumber = MeterUtil.getRangeNumber(numMax);
            System.out.println("目标值" + rangeNumber);
            //            Integer numForHalf = getNumForHalf(arr, rangeNumber);
            Integer numForHalf = getNumForHalfLeft(arr, rangeNumber);
            Integer test = test(arr, rangeNumber);
            if ((numForHalf == null || test == null)) {
                if (numForHalf == null && test == null) {
                    System.out.println(test + " &&&" + numForHalf);
                } else {
                    System.out.println("出错" + test + " &&&" + numForHalf);
                }
            } else {
                if (!numForHalf.equals(test)) {
                    System.out.println("出错" + test + " &&&" + numForHalf);
                } else {
                    System.out.println(test + " &&&" + numForHalf);
                }
            }
        }
        System.out.println("no problem");
    }

    public static Integer getNumForHalf(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1); // ( L + R )/ 2
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return null;
    }

    public static Integer getNumForHalfLeft(int[] arr, int num) {
        int N = arr.length - 1;
        int L = 0;
        int R = arr.length - 1;
        int indexLeft = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                indexLeft = mid;
                mid--;
                while (mid >= 0 && arr[mid] == num) {
                    indexLeft = mid;
                    mid--;
                }
                break;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return indexLeft != -1 ? indexLeft : null;
    }

    public static Integer test(int arr[], int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return null;
    }
}
