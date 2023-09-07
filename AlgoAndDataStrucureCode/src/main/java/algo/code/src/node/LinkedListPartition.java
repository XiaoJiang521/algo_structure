package algo.code.src.node;

import util.Node;

public class LinkedListPartition {
    public static Node getPartitionNode(Node head, int value) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node hH = null;
        Node hT = null;

        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < value) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.value == value) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            } else {
                if (hH == null) {
                    hH = head;
                    hT = head;
                } else {
                    hT.next = head;
                    hT = hT.next;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            // eT 如果不是空 用 eT去连接 ，是空  用sT 去连
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = hH;
        }
        return sH == null ? (eH == null ? hH : eH) : sH;
    }
}
