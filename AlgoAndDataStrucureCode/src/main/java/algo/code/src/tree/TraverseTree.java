package algo.code.src.tree;

import util.MeterUtil;
import util.PrintBinaryTree;
import util.TreeNode;

import java.util.Stack;

public class TraverseTree {
    /**
     * 递归遍历树
     *
     * @param head
     */
    public static void recursionTree(TreeNode head) {
        if (head == null) {
            return;
        }
        recursionTree(head.left);
        recursionTree(head.right);
    }

    /**
     * 非递归遍历树
     *
     * @param head
     */
    public static void unRecursionTree(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> treeStack = new Stack<>();
            treeStack.add(head);
            while (!treeStack.isEmpty()) {
                head = treeStack.pop();
                if (head.left != null) {
                    treeStack.add(head.left);
                }
                if (head.right != null) {
                    treeStack.add(head.right);
                }
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param head
     */
    public static void preTree(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + "  ");
        preTree(head.left);
        preTree(head.right);
    }

    /**
     * 中序遍历
     *
     * @param head
     */
    public static void inTree(TreeNode head) {
        if (head == null) {
            return;
        }
        inTree(head.left);
        System.out.print(head.value + "  ");
        inTree(head.right);
    }

    /**
     * 后序遍历
     *
     * @param head
     */
    public static void proTree(TreeNode head) {
        if (head == null) {
            return;
        }
        proTree(head.left);
        proTree(head.right);
        System.out.print(head.value + "  ");
    }

    public static void main(String[] args) {
        TreeNode treeNode = MeterUtil.generateTree(1, 3, 20);
        PrintBinaryTree.printTree(treeNode);

        preTree(treeNode);
        MorrisTree.pre(treeNode);
        System.out.println(" ==================== ");
        inTree(treeNode);
        System.out.println(" ==================== ");
        proTree(treeNode);
        System.out.println(" ==================== ");
    }
}
