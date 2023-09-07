package algo.code.src.slidwindow;

/*
   给定一个整数组成的无序数组arr，值可能正、可能负、可能0。给定一个整数值K，
   找到arr的所有子数组里，哪个子数组的累加和<=K，并且是长度最大的。返回其长度。
   https://www.cnblogs.com/waitmoon/p/14598663.html
*/
public class Arr {
    public static void main(String[] args) {
        int arr[] = new int[] {1000, -10, 60, -60, 3, 1, -2, 1, 10};
        int k = 1;
        System.out.println(getMaxSubArr(arr, k));
    }

    public static int getMaxSubArr(int[] arr, int k) {
        int index = -1;
        int[] sumArr = new int[arr.length];
        int maxLen = -1;
        for (int i = 0; i < arr.length; i++) {
            sumArr[i] = arr[i] + (i == 0 ? 0 : sumArr[i - 1]);
            while (sumArr[i] - (index == -1 ? 0 : sumArr[index]) > k && index <= i) {
                // 不包括i 位置的值  所以不用 +1
                maxLen = Math.max(maxLen, i - index - 1);
                index++;
            }
        }
        return maxLen == -1 ? 0 : maxLen;
    }
}
