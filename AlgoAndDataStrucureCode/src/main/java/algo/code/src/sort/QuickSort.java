package algo.code.src.sort;

public class QuickSort {
    // 以 arr[R] 位置做划分值  无重复？ 如果有重复可能会出问题
    public static int partition(int arr[], int L, int R) {
        if (L > R) {
            return -1;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }

        swap(arr, R, ++lessEqual);
        return lessEqual;
    }

    //  返回分界值的边界数组，
    // 以 arr[R] 为边界
    public static int[] partitionReturnNether(int arr[], int L, int R) {
        if (L > R) {
            return new int[] {-1, -1};
        }
        if (L == R) {
            return new int[] {L, R};
        }
        int lessEqual = L - 1; // 左边界
        int right = R; // 右边界
        int index = L;
        while (index < right) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++lessEqual);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, index, --right);
            }
        }
        swap(arr, R, right);
        return new int[] {lessEqual + 1, right};
    }

    public static void quickSortStrength(int arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickProcess(arr, 0, arr.length - 1);
    }

    public static void quickProcess(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArr = partitionReturnNether(arr, L, R);
        quickProcess(arr, L, equalArr[0] - 1);
        quickProcess(arr, equalArr[1] + 1, R);
    }

    public static void swap(int arr[], int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
