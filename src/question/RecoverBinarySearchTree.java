package question;

import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class RecoverBinarySearchTree {
    static TreeNode pre = null, first = null, second = null;
    public static void recoverTree(TreeNode root) {
        recoverTreeHelper(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public static void recoverTreeHelper(TreeNode root) {
        if (root == null) return;
        recoverTreeHelper(root.left);
        if (pre == null) pre = root;
        else if (root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        recoverTreeHelper(root.right);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(7);
        n1.right = n2;
        //n1.right = n3;
        //n2.left = n4;
        recoverTree(n1);
        inorder(n1);
    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
