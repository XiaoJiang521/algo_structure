package algo.code.src.slidwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 滑动窗口每次只向右移动一位。
 返回 滑动窗口中的最大值 。
*/
public class SlidWindowMaxArrayLeetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int res[] = new int[len - k + 1];
        int index = 0;
        for (int R = 0; R < len; R++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[R]) {
                deque.pollLast();
            }
            deque.addLast(R);
            if (!deque.isEmpty() && deque.peekFirst() == R - k) {
                deque.pollFirst();
            }
            if (R >= k - 1 && !deque.isEmpty()) {
                //                res[R - k + 1] = nums[deque.peekFirst()];
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
