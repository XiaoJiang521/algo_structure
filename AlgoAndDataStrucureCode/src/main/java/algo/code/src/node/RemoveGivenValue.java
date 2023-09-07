package algo.code.src.node;

import util.Node;

public class RemoveGivenValue {

    public static Node removeValue(Node head, int value) {
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.value == value) {
                // 例如 value = 2
                // pre  1 -> 3 -> 5
                // cur 5
                pre.next = cur.next;
            } else {
                // cur.value != value 的时候，pre的next指向了cur的next pre直接指向cur就可以
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
