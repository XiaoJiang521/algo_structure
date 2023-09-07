package algo.code.src.dynamicplan;

import java.util.HashMap;
import java.util.Map;

/*
请找到等于 K 的最长时间段(即:多包、丢包和正常之和等于 K 的最长连续子数组长度)。如果不存在任意 一个符合要求的时间段，则返回 0。

注意:
nums 数组的总和是一定在 32 位有符号整数范围之内的。

示例 1:
输入: nums = [1, -1, 5, -2, 3], k = 3
输出: 4
解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。

示例 2:
输入: nums = [-2, -1, 2, 1], k = 1
输出: 2
解释: 子数组 [-1, 2] 和等于 1，且长度最长。


 */
public class Leetcode325 {

    public static void main(String[] args) {
        int arr[] = new int[] {1, -1, 5, -2, 3};
        int arr1[] = new int[] {0, -1, 2, 1};
        int arr2[] = new int[] {-2, -1, -3, -4};
        int arr3[] = new int[] {};
        int arr4[] = new int[] {0, 0, 0, -2, 2};
        System.out.println(getNumLenMax1(arr, 8));
        System.out.println(getNumLenMax1(arr1, 1));
        System.out.println(getNumLenMax1(arr2, -3));
        System.out.println(getNumLenMax1(arr3, -7));
        System.out.println(getNumLenMax1(arr4, 0));

        System.out.println("====");
        System.out.println(getNumLenInMap(arr, 8));
        System.out.println(getNumLenInMap(arr1, 1));
        System.out.println(getNumLenInMap(arr2, -3));
        System.out.println(getNumLenInMap(arr3, -7));
        System.out.println(getNumLenInMap(arr4, 0));
    }

    public static int getNumLenMax1(int[] num, int k) {
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            int sum = 0;
            for (int j = i; j < num.length; j++) {
                sum += num[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    public static int getNumLenInMap(int[] num, int k) {
        int preSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 兼容 preSum = k的时候  就是从第一个位置开始的
        map.put(0, -1);
        for (int i = 0; i < num.length; i++) {
            preSum += num[i];
            if (!map.containsKey(preSum)) {
                // 保证 相同的 preSum 是最左边的，因为距离更长
                map.put(preSum, i);
            }
            if (map.containsKey(preSum - k)) {
                res = Math.max(res, i - map.get(preSum - k));
            }
        }

        return res;
    }

    //    public  static int dp(int prei,int [] num, int k){
    //
    //        if()
    //        int maxLen = Integer.MIN_VALUE;
    //        for (int i = 0; i < num.length; i++) {
    //            int sum = 0;
    //            dp(i,num,k);
    //            for (int j = i; j < num.length; j++) {
    //                sum += num[j];
    //                if(sum == k){
    //                    maxLen = Math.max(maxLen, j - i + 1);
    //                }
    //            }
    //
    //        }
    //        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    //    }

    public static int getNumLenMax(int[] num, int k) {

        int start = 0;
        int end = 0;
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        while (start < num.length) {
            sum += num[start];
            while (sum == k) {
                maxLen = Math.max(maxLen, start - end + 1);
                sum -= num[end++];
            }

            start++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
