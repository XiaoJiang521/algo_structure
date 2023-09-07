package algo.code.src.node;

import util.DoubleNode;

public class DoubleLinkedList {

    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
