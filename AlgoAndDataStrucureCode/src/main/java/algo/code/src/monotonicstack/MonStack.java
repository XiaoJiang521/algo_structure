package algo.code.src.monotonicstack;

import java.util.Stack;

public class MonStack {
    /*
       使用stack 获取 arr 中每个元素离自己最近的 最小的值的位置
    */
    public static int[][] getMonStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                Integer pop = stack.pop();
                // 记录pop 位置的 左右两边第一个 比自己小的位置
                // pop 在战中的下一个元素 ，就是左边第一个比自己小的
                int left = stack.isEmpty() ? -1 : stack.peek();
                // i 位置的元素 ，就是右边第一个比自己小的
                //                int right = i;
                res[pop][0] = left;
                res[pop][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            // 记录pop 位置的 左右两边第一个 比自己小的位置
            // pop 在战中的下一个元素 ，就是左边第一个比自己小的
            int left = stack.isEmpty() ? -1 : stack.peek();
            // 此时在栈中的元素 ，右边没有比自己小的
            //                int right = i;
            res[pop][0] = left;
            res[pop][1] = -1;
        }
        return res;
    }

    /*
       使用数组 压缩栈空间
    */
    public static int[][] getMonStackArr(int arr[]) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 栈中最大就是 arr 的长度
        int stack[] = new int[arr.length];
        int[][] res = new int[arr.length][2];
        // 栈的 peek 指针 (栈顶元素指针)
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            while (index != -1 && arr[stack[index]] > arr[i]) {
                int pop = stack[index--];
                int left = index == -1 ? -1 : stack[index];
                res[pop][0] = left;
                res[pop][1] = i;
            }
            stack[++index] = i;
        }
        while (index != -1) {
            int pop = stack[index--];
            int left = index == -1 ? -1 : stack[index];
            res[pop][0] = left;
            res[pop][1] = -1;
        }
        return res;
    }

    // ==================  for test
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + "   ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][1] + "   ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {10, 2, 5, 7, 6, 11, 20, 19, 18};
        int[][] monstack = getMonStack(arr);
        print(monstack);
        System.out.println("============================");
        int[][] aaa = getMonStackArr(arr);
        print(aaa);
    }
}
