package algo.code.src.util;

public class kmp {

    public static int getCommonStrLen(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // O (M )
        int[] next = getNext(chars2);

        // 双指针 同时从 str1 和 str2 比较
        int x = 0;
        int y = 0;
        //        o(N)
        while (x < chars1.length && y < chars2.length) {
            if (chars1[x] == chars2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // == -1  说明到初始位置 0 了
                // y 已经是 0 了
                x++;
            } else {
                // y 回退到next 数组的值 位置
                y = next[y];
            }
        }
        return y == chars2.length ? x - y : -1;
    }

    public static int[] getNext(char[] str) {
        if (str.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[str.length];
        next[0] = -1; // 0位置为起点
        next[1] = 0; // 1位置也没有定义的值
        int cn = 0; // 从起点开始比较的值，同时也是next数组赋值的数字，因为cn的值是从起点开始
        int i = 2;
        while (i < str.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                // 更新cn 到cn 位置的next值
                cn = next[cn];
            } else {
                i++;
                // 同时next[i ] 位置也是 0 不用特意设置
            }
        }

        return next;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (getCommonStrLen(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
