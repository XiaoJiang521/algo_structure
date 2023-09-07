package algo.code.src.util;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MeterUtil {
    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * 有重复
     *
     * @param len 闯入数组长度
     * @param numMax 数组内数字最大值
     * @return 目标数组
     */
    public static int[] getArr(int len, int numMax) {
        return getArr(len, numMax, false);
    }

    /**
     * 有重复
     *
     * @param len 闯入数组长度
     * @param numMax 数组内数字最大值
     * @return 目标数组
     */
    public static int[] getArr(int len, int numMax, boolean hasNeg) {
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = hasNeg ? getRangeNumber(numMax) : (int) (Math.random() * numMax + 1);
        }
        return arr;
    }

    /**
     * 无重复
     *
     * @param len 闯入数组长度
     * @param numMax 数组内数字最大值
     * @return 目标数组
     */
    public static int[] getArrNoRepetition(int len, int numMax, boolean hasNeg) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            hashSet.add(hasNeg ? getRangeNumber(numMax) : (int) (Math.random() * numMax + 1));
        }
        int arr[] = new int[hashSet.size()];
        int index = 0;
        for (Integer num : hashSet) {
            arr[index++] = num;
        }
        return arr;
    }

    /**
     * 有重复
     *
     * @param len 闯入数组长度
     * @param numMax 数组内数字最大值
     * @return 目标数组
     */
    public static int[] getArrNoRepetition(int len, int numMax) {
        return getArr(len, numMax, false);
    }

    // [-range, +range]
    public static int getRangeNumber(int range) {
        return (int) (Math.random() * (range + 1) - (int) (Math.random() * (range + 1)));
    }

    /**
     * 复制数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArr(int arr[]) {
        int arrRes[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrRes[i] = arr[i];
        }

        return arrRes;
    }

    /*
       比较数组
    */
    public static boolean judge(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println(
                        "返回的值不对 : 第" + i + "位置的数字 arr1=" + arr1[i] + " * arr2=" + arr2[i]);
                System.out.println(arr1.length);
                return false;
            }
        }
        return true;
    }

    /** 获取一个随机单链表 */
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }

        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size > 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = pre.next;
            size--;
        }
        return head;
    }

    /** 获取一个随机的有序单链表 */
    public static Node generateRandomOrderLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (size > 0) {
            priorityQueue.add((int) (Math.random() * (value + 1)));
            size--;
        }
        Node head = null;
        if (!priorityQueue.isEmpty()) {
            head = new Node(priorityQueue.poll());
        }
        Node pre = head;
        while (!priorityQueue.isEmpty()) {
            pre.next = new Node(priorityQueue.poll());
            pre = pre.next;
        }
        return head;
    }

    /** 获取一个随机双链表 */
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }

        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size > 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = pre.next;
            size--;
        }
        return head;
    }
    /** 获取一个随机有环链表 */
    public static Node generateRandomRingList(int len, int value) {
        Node linkedList = MeterUtil.generateRandomLinkedList(len, value);
        // 打印原链表
        System.out.print("原链表: " + "   ");
        printLinkedListNode(linkedList);
        Node tail = linkedList;
        int index = 0;
        while (tail != null && tail.next != null) {
            tail = tail.next;
            index++;
        }
        System.out.println("尾部是 : " + (tail != null ? tail.value : null));

        if (tail != null) {
            int randomNode = (int) (Math.random() * index);
            Node ranNode = linkedList;
            index = 0;
            while (ranNode != null) {
                if (index == randomNode) {
                    break;
                }
                ranNode = ranNode.next;
                index++;
            }
            tail.next = ranNode;
        }
        System.out.print("变成有环链表后: " + "   ");
        printRingLinkedListNode(linkedList, len);
        return linkedList;
    }

    public static void printRingLinkedListNode(Node head, int len) {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
            if (index++ > 2 * len + 5) {
                break;
            }
        }
        System.out.println();
    }

    public static void printLinkedListNode(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void printDoubleListNode(DoubleNode head) {
        DoubleNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.println();
        DoubleNode cur1 = head;
        while (cur1 != null) {
            System.out.print(cur1.value + " <- ");
            cur1 = cur1.next;
        }

        System.out.println();
    }

    // 生成一棵树
    public static TreeNode generateTree(int level, int maxLevel, int maxValue) {
        //        if (level > maxLevel || Math.random() < 0.5) {
        //            return null;
        //        }
        if (level > maxLevel) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generateTree(level + 1, maxLevel, maxValue);
        head.right = generateTree(level + 1, maxLevel, maxValue);
        return head;
    }
}
