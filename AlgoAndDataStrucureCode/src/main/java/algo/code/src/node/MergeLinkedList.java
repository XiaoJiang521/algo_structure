package algo.code.src.node;

import util.Node;

public class MergeLinkedList {
    public static Node mergeList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int headNum = 0;
        if (cur1.value >= cur2.value) {
            headNum = cur2.value;
            cur2 = cur2.next;
        } else {
            headNum = cur1.value;
            ;
            cur1 = cur1.next;
        }
        Node res = new Node(headNum);
        Node pre = res;
        while (cur1 != null && cur2 != null) {
            if (cur1.value >= cur2.value) {
                headNum = cur2.value;
                cur2 = cur2.next;
            } else {
                headNum = cur1.value;
                ;
                cur1 = cur1.next;
            }
            pre.next = new Node(headNum);
            pre = pre.next;
        }
        while (cur1 != null) {
            pre.next = new Node(cur1.value);
            pre = pre.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            pre.next = new Node(cur2.value);
            pre = pre.next;
            cur2 = cur2.next;
        }
        return res;
    }
}
