package algo.code.src.node;

import util.MeterUtil;
import util.Node;

public class HasRollList {

    public static void main(String[] args) {

        Node linkedList = MeterUtil.generateRandomRingList(20, 20);

        Node hasRollLinkedList = isHasRollLinkedList(linkedList);
        System.out.println(hasRollLinkedList.value);
    }

    public static Node isHasRollLinkedList(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node low = head.next;
        Node fast = head.next.next;
        while (fast != low) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            low = low.next;
        }

        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
