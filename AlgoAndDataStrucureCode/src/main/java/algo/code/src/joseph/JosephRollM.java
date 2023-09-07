package algo.code.src.joseph;

import java.util.PriorityQueue;

/*
   100个人围成一圈，每个人有一个编码，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，
   然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
*/
public class JosephRollM {

    public static void soutRollM(int N, int M) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < M - 1; i++) {
            priorityQueue.add(getMPosition(N, M, i) + 1);
        }


        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ,");
        }
    }

    /*
       根据 f(N, M) =   (f(N - 1, M) +M )% N 来反推（公式根据数组下标）
       当只剩最后一个人的时候，他的位置一定是1，以此可以反推最后一个人的初始位置
       同理 ，剩最后 M - 1个人的时候 ，从 0 ~ M - 2 的人 每个人的位置 也是 0 ~ M - 2，即第i个人的位置 时 i
       那么根据推理公式，可以直接到剩i 个人时，反推 i 的 初始位置
       这是递归的 basecase终止条件，为 剩余的N个人 == i ， return i;
    */
    public static int getMPosition(int N, int M, int index) {
        if (N == index) {
            return index;
        }
        return (getMPosition(N - 1, M, index) + M) % N;
        /*
           f ( 2 , 3) = (f(1 , 3 ) + 3 %) 2
           f( 3 ,3
           f( 4 ,3

             f( 3 , 3 ) =(  f( 2 , 3 ) + 3 )% 3
        */
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int N = (int) (Math.random() * 1000);
            int M = (int) (Math.random() * N);
            if (N == 0 || M == 0) {
                continue;
            }
            System.out.println("第" + i + "行=====================================");
            soutRollM(N, M);
            System.out.println();
            soutLowRoll(N, M);
            System.out.println();
        }
    }

    /*
       笨方法
    */
    public static void soutLowRoll(int N, int M) {
        int arr[] = new int[N + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        int rest = N;
        int index = 0;
        while (rest >= M) {
            for (int i = 1; i < N + 1; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                index++;
                if (index == M) {
                    arr[i] = 0;
                    index = 0;
                    rest--;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ,");
            }
        }
    }
}
