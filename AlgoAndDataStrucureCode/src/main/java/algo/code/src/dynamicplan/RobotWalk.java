package algo.code.src.dynamicplan;

/*
假设有排成一行的N个位置记为1到N ，N一定大于等于2
开始时机器人在其中的M位置上，M一定是1到N中的一个
如果机器人来到1位置那么下一步只能往右来到2位置
如果机器人来到N位置那么下一步只能往左来到N-1的位置
机器人在其他位置，既可以往左移动，也可以往右移动
机器人一共可以走K步
*/
public class RobotWalk {
    /*
       N 一行的长度
       M 开始位置
       K 机器人一共可以走的步
       AIM 机器人的目标位置
    */
    public static int ways1(int N, int M, int K, int AIM) {
        return process1(N, K, AIM, M);
    }

    /*
       cur 当前位置
       rest 剩余步数
    */
    public static int process1(int N, int rest, int AIM, int cur) {
        if (rest == 0) {
            return cur == AIM ? 1 : 0;
        }
        if (cur == 1) {
            // 1位置 只能往 2 位置走  同时 1位置 剩 rest 步 ，和 2位置 剩 rest -1 步的 值是一样的，可以直接return
            return process1(N, rest - 1, AIM, 2);
        }
        if (cur == N) {
            // N 位置 只能往 N - 1位置走 与 1位置同理
            return process1(N, rest - 1, AIM, N - 1);
        }
        // cur 位置 rest 步 =  ( cur - 1位置 rest -1 步) + (cur + 1 位置 rest -1步)
        return process1(N, rest - 1, AIM, cur - 1) + process1(N, rest - 1, AIM, cur + 1);
    }

    public static int ways2(int N, int M, int K, int AIM) {

        int dp[][] = new int[K + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(N, K, AIM, M, dp);
    }

    public static int process2(int N, int rest, int AIM, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        int ans = 0;
        if (rest == 0) {
            return ans = cur == AIM ? 1 : 0;
        } else if (cur == 1) {
            // 1位置 只能往 2 位置走  同时 1位置 剩 rest 步 ，和 2位置 剩 rest -1 步的 值是一样的，可以直接return
            ans = process1(N, rest - 1, AIM, 2);
        } else if (cur == N) {
            // N 位置 只能往 N - 1位置走 与 1位置同理
            ans = process1(N, rest - 1, AIM, N - 1);
        } else {
            // cur 位置 rest 步 =  ( cur - 1位置 rest -1 步) + (cur + 1 位置 rest -1步)
            ans = process1(N, rest - 1, AIM, cur - 1) + process1(N, rest - 1, AIM, cur + 1);
        }
        // 记忆缓存
        dp[rest][cur] = ans;
        return ans;
    }

    public static int ways3(int N, int M, int K, int AIM) {
        int dp[][] = new int[K + 1][N + 1];
        // 步数，行
        // 位置，列
        dp[0][AIM] = 1;
        // 0 步已经全部赋完值了
        for (int rest = 1; rest < dp.length; rest++) {
            // 没有 0位置
            //            for (int cur = 1; cur < dp[0].length; cur++) {
            //                if (cur == 1){
            //                    dp[rest][cur] = dp[rest - 1][2];
            //                } else if (cur == N){
            //                    dp[rest][cur] = dp[rest - 1][N - 1];
            //                } else {
            //                    dp[rest][cur] = dp[rest - 1][cur - 1] + dp[rest - 1][cur + 1] ;
            //                }
            //            }
            // 循环优化
            dp[rest][1] = dp[rest - 1][2];
            for (int cur = 2; cur < dp[0].length - 1; cur++) {
                dp[rest][cur] = dp[rest - 1][cur - 1] + dp[rest - 1][cur + 1];
            }
            dp[rest][N] = dp[rest - 1][N - 1];
        }
        return dp[K][M];
    }

    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 6, 4));
        System.out.println(ways2(5, 2, 6, 4));
        System.out.println(ways3(5, 2, 6, 4));
    }
}
