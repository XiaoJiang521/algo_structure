package algo.code.src.half;

public class PartHalf {
    public static void main(String[] args) {
        int arr[] = new int[] {10, 3, 5, 7, 5, 10, 13, 15, 17};
        System.out.println(getNumForHalf(arr));
    }

    public static Integer getNumForHalf(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // 只有 1 个数字  或者 0 < 1
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        // 因为 mid 要判断 mid + 1和 -1 所以从 1 和 arr.length - 2 开始
        int L = 1;
        int R = arr.length - 2;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                R = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid - 1;
            }
        }
        return null;
    }
}
