package algo.code.src.tree;

import util.TreeNode;

/*
   morris 遍历
   有左孩子
       左孩子的最右指针，指向的null  把左孩子最右指针指向自己， cur 向右移动
       左孩子的最右指针，指向的自己   把左孩子最右指针指向null ，cur 向左移动
   没有左孩子 直接向右走
*/
public class MorrisTree {

    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.value + "  ");
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}
