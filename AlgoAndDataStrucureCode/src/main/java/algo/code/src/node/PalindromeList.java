package algo.code.src.node;

import util.MeterUtil;
import util.Node;

import java.util.Stack;

/*
   给定一个单链表，判断单链表的值是否是回文结构
*/
public class PalindromeList {

    public static void main(String[] args) {

        Node head = null;
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        MeterUtil.printLinkedListNode(head);
        System.out.print(isPalindromeList(head) + " | ");
        System.out.print(isPalindromeListForStack(head) + " | ");
        MeterUtil.printLinkedListNode(head);
        System.out.println("=========================");
    }

    public static boolean isPalindromeList(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node low = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        // low指向了中点
        // 分隔开个链表
        fast = low.next;
        low.next = null;
        Node temp;
        while (fast != null) {
            temp = fast.next;
            // 直接使用low 相当于pre节点
            fast.next = low;
            low = fast;
            fast = temp;
        }
        temp = low; // 保存下最后一个节点，最后链表要还原
        fast = head;
        boolean res = true;
        while (low != null && fast != null) {
            if (low.value != fast.value) {
                res = false;
                break;
            }
            low = low.next;
            fast = fast.next;
        }
        // 还原
        fast = temp;
        low = null;
        while (fast != null) {
            temp = fast.next;
            fast.next = low;
            low = fast;
            fast = temp;
        }
        return res;
    }

    public static boolean isPalindromeListForStack(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.add(cur.value);
            cur = cur.next;
        }
        boolean res = true;
        cur = head;
        while (!stack.isEmpty() && cur != null) {
            if (cur.value != stack.pop()) {
                res = false;
                break;
            }
            cur = cur.next;
        }
        return res;
    }
}
