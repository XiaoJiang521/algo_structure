package algo.code.src.dynamicplan;

public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text2.length() == 0 || text1.length() == 0) {
            return 0;
        }
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        dp(str1, str2);
        return process(str1, str2, str1.length - 1, str2.length - 1);
    }

    // s1 s2 从尾部开始 ，从头开始也一样
    public static int process(char[] str1, char[] str2, int s1, int s2) {
        if (s1 == 0 && s2 == 0) {
            return str1[s1] == str2[s2] ? 1 : 0;
            // 有可能其中一个先到 0位置
        } else if (s1 == 0) {
            if (str1[s1] == str2[s2]) {
                return 1;
            }
            return process(str1, str2, s1, s2 - 1);
        } else if (s2 == 0) {
            if (str1[s1] == str2[s2]) {
                return 1;
            }
            return process(str1, str2, s1 - 1, s2);
        } else {
            // 都没到 0
            // 要么 s1 s2 位置相等 要么不相等
            int noEqualS1 = process(str1, str2, s1 - 1, s2);
            int noEqualS2 = process(str1, str2, s1, s2 - 1);
            int equal = str1[s1] == str2[s2] ? 1 + process(str1, str2, s1 - 1, s2 - 1) : 0;
            return Math.max(noEqualS1, Math.max(noEqualS2, equal));
        }
    }

    public static int dp(char[] str1, char[] str2) {
        int s1 = str1.length;
        int s2 = str2.length;
        int dp[][] = new int[s1][s2];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < s2; i++) {
            dp[0][i] = str1[0] == str2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < s1; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < s1; i++) {
            for (int j = 1; j < s2; j++) {

                // 都没到 0
                // 要么 s1 s2 位置相等 要么不相等
                int noEqualS1 = dp[i - 1][j];
                int noEqualS2 = dp[i][j - 1];
                int equal = str1[i] == str2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(noEqualS1, Math.max(noEqualS2, equal));
            }
        }
        return dp[s1 - 1][s2 - 1];
    }
}
