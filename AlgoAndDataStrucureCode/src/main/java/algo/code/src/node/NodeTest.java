package algo.code.src.node;

import util.MeterUtil;
import util.Node;

public class NodeTest {
    public static void main(String[] args) {
        int nodeLen = 10;
        int nodeValue = 10;
        //        Node node = MeterUtil.generateRandomLinkedList(nodeLen, nodeValue);
        //        DoubleNode doubleNode = MeterUtil.generateRandomDoubleList(nodeLen, nodeValue);
        //
        //        MeterUtil.printLinkedListNode(node);
        //        Node node1 = RemoveGivenValue.removeValue(node, 5);
        //        MeterUtil.printLinkedListNode(node1);

        //        Node linkedList = LinkedList.reverseLinkedList(node);
        //        MeterUtil.printLinkedListNode(linkedList);

        //        MeterUtil.printDoubleListNode(doubleNode);
        //        DoubleNode doubleNodeList = DoubleLinkedList.reverseDoubleLinkedList(doubleNode);
        //        MeterUtil.printDoubleListNode(doubleNodeList);
        // merger linst
        //        Node linkedList = MeterUtil.generateRandomOrderLinkedList(nodeLen, nodeValue);
        //        Node linkedList2 = MeterUtil.generateRandomOrderLinkedList(nodeLen, nodeValue);
        //
        //        MeterUtil.printLinkedListNode(linkedList);
        //        MeterUtil.printLinkedListNode(linkedList2);
        //
        //        MeterUtil.printLinkedListNode(MergeLinkedList.mergeList(linkedList,linkedList2));

        //  链表分成左中右 3 部分
        Node linkedList = MeterUtil.generateRandomLinkedList(nodeLen, nodeValue);
        MeterUtil.printLinkedListNode(linkedList);
        Node partitionNode = LinkedListPartition.getPartitionNode(linkedList, 5);
        MeterUtil.printRingLinkedListNode(partitionNode, 10);
    }
}
