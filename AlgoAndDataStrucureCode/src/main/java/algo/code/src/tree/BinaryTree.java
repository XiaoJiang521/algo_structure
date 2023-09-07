package algo.code.src.tree;

import util.MeterUtil;
import util.PrintBinaryTree;
import util.TreeNode;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = MeterUtil.generateTree(5, 6, 10);
        PrintBinaryTree.printTree(treeNode);
    }
}
