package algo.code.src.dynamicplan.package01;

import java.util.Arrays;

/*
 https://leetcode.cn/problems/partition-equal-subset-sum/
   有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。

   每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

   如果 x == y，那么两块石头都会被完全粉碎；
   如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
   最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。

*/
public class Leetcode1049 {
    /*
       思路

    */

    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        //        int minStones = process(stones, sum / 2, 0);
        //        int minStones = dpMethod(stones, sum / 2, 0);
        int minStones = dpMethodCompress(stones, sum / 2, 0);
        return sum - 2 * minStones;
    }

    /*
       递归会超时
    */
    public static int process(int[] stones, int rest, int index) {
        if (rest < 0) {
            return -1;
        }
        int N = stones.length;
        if (index == N) {
            return 0;
        }
        int p1 = process(stones, rest, index + 1);
        int p2 = 0;
        int next = process(stones, rest - stones[index], index + 1);
        if (next != -1) {
            p2 = next + stones[index];
        }
        return Math.max(p1, p2);
    }

    /*
       二维数组，
       index 0~ N
       rest 0 ~ bag
    */
    public static int dpMethod(int[] stones, int rest, int index) {
        int N = stones.length;
        int dp[][] = new int[N + 1][rest + 1];
        // 根据暴力递归， index 应该从N - 1行开始填
        // process(stones, rest, index + 1);  以来的 index + 1行
        // 根据base case index == N  第 N 行 全部为 0
        for (int ind = N - 1; ind >= 0; ind--) {
            for (int res = 0; res <= rest; res++) {
                int p1 = dp[ind + 1][res];
                int p2 = 0;
                int next = res - stones[ind] >= 0 ? dp[ind + 1][res - stones[ind]] : -1;
                if (next != -1) {
                    p2 = next + stones[ind];
                }
                dp[ind][res] = Math.max(p1, p2);
            }
        }
        return dp[0][rest];
    }

    /*
       数组压缩
    */
    public static int dpMethodCompress(int[] stones, int rest, int index) {
        int N = stones.length;
        // 记录的时每一个 index 行 rest 容量的值
        int dp[] = new int[rest + 1];
        // 根据暴力递归， index 应该从N - 1行开始填
        // process(stones, rest, index + 1);  以来的 index + 1行
        // 根据base case index == N  第 N 行 全部为 0
        int dpAssist[] = new int[rest + 1];
        for (int ind = N - 1; ind >= 0; ind--) {
            for (int i = 0; i < dp.length; i++) {
                dpAssist[i] = dp[i];
            }
            for (int res = 0; res <= rest; res++) {
                int p1 = dpAssist[res];
                int p2 = 0;
                int next = res - stones[ind] >= 0 ? dpAssist[res - stones[ind]] : -1;
                if (next != -1) {
                    p2 = next + stones[ind];
                }
                dp[res] = Math.max(p1, p2);
            }
        }
        return dp[rest];
    }

    public static void main(String[] args) {
        int arr[] = new int[] {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(arr));
    }
}
