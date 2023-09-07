package algo.code.src.bitopt.bit;

/** */
public class EvenOdd {
    /** 一种数出现了奇数次，其他数出现了偶数次 找到这个数 */
    public static int getOddOne(int arr[]) {
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            odd = odd ^ arr[i];
        }
        return odd;
    }

    /** 两种数出现了奇数次，其他数出现了偶数次 找到这个数 */
    public static int[] getOddTwo(int arr[]) {
        int resArr[] = new int[2];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }

        // 找到最后一位1
        int resEnd = res & (~res + 1);
        int resTemp = 0;
        for (int i = 0; i < arr.length; i++) {
            // 相同位置为 1
            //  0010
            //  1111
            if ((arr[i] & resEnd) == 1) {
                resTemp ^= arr[i];
            }
        }
        resArr[0] = resTemp;
        resArr[1] = resTemp ^ res;
        return resArr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1, 4, 4};
        System.out.println(getOddOne(arr));

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2, 6, 6};
        int[] oddTwo = getOddTwo(arr2);
        for (int i = 0; i < oddTwo.length; i++) {
            System.out.print(oddTwo[i] + " ***");
        }
    }
}
