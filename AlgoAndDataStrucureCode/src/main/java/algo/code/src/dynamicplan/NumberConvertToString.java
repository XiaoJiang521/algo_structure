package algo.code.src.dynamicplan;

import util.StringUtil;

/*
   规定1对应A 2对应B 3对应C依此类推26对应Z那么一个数字字符串比如111就可以转化为AAA KA Ak
   给定一个只有数字字符组成的字符串str返回有多少种
*/
public class NumberConvertToString {
    public static int numberToString(String number) {
        if (StringUtil.isEmpty(number)) {
            return 0;
        }
        return process(number.toCharArray(), 0);
    }

    public static int process(char[] str, int cur) {
        if (cur == str.length) {
            return 1;
        }
        if (str[cur] == '0') {
            // 0不能转换
            return 0;
        }
        // cur 算一个字符 cur 后面可以组成多少种
        int ways = process(str, cur + 1);
        // 使用 当前字符，或者当前字符 + 下一个字符
        if (cur + 1 < str.length && ((str[cur] - '0') * 10 + (str[cur + 1] - '0')) < 27) {
            ways += process(str, cur + 2);
        }
        return ways;
    }

    public static int numberDp(String number) {
        if (StringUtil.isEmpty(number)) {
            return 0;
        }
        char[] str = number.toCharArray();
        int dp[] = new int[number.length() + 1];
        dp[number.length()] = 1;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != '0') {
                int ways = dp[i + 1];
                if (i + 1 < str.length && ((str[i] - '0') * 10 + (str[i + 1] - '0')) < 27) {
                    ways += dp[i + 2];
                }
                dp[i] = ways;
            }
        }
        return dp[0];
    }

    // 为了测试
    public static String randomString(int len) {
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = (char) ((int) (Math.random() * 10) + '0');
        }
        return String.valueOf(str);
    }
    // 从左往右的动态规划
    // dp[i]表示：str[0...i]有多少种转化方式
    public static int dp2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        if (str[0] == '0') {
            return 0;
        }
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            if (str[i] == '0') {
                // 如果此时str[i]=='0'，那么他是一定要拉前一个字符(i-1的字符)一起拼的，
                // 那么就要求前一个字符，不能也是‘0’，否则拼不了。
                // 前一个字符不是‘0’就够了嘛？不够，还得要求拼完了要么是10，要么是20，如果更大的话，拼不了。
                // 这就够了嘛？还不够，你们拼完了，还得要求str[0...i-2]真的可以被分解！
                // 如果str[0...i-2]都不存在分解方案，那i和i-1拼成了也不行，因为之前的搞定不了。
                if (str[i - 1] == '0' || str[i - 1] > '2' || (i - 2 >= 0 && dp[i - 2] == 0)) {
                    return 0;
                } else {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] : 1;
                }
            } else {
                dp[i] = dp[i - 1];
                if (str[i - 1] != '0' && (str[i - 1] - '0') * 10 + str[i] - '0' <= 26) {
                    dp[i] += i - 2 >= 0 ? dp[i - 2] : 1;
                }
            }
        }
        return dp[N - 1];
    }

    // 为了测试
    public static void main(String[] args) {
        int N = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N);
            String s = randomString(len);
            int ans0 = numberToString(s);
            int ans1 = numberDp(s);
            int ans2 = dp2(s);
            if (ans0 != ans1 || ans0 != ans2) { // ans0 != ans1 ||
                System.out.println(s);
                System.out.println(ans0);
                //                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
