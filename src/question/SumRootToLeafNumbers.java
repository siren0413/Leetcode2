package question;

import beans.*;

/**
 * Created by siren0413 on 1/27/14.
 */
public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbersHelper(root, 0);
    }
    private static int sumNumbersHelper(TreeNode root, int num) {
        if (root.left == null && root.right == null)
            return num * 10 + root.val;
        return (root.left != null ? sumNumbersHelper(root.left, num * 10 + root.val) : 0) + (root.right != null ? sumNumbersHelper(root.right, num * 10 + root.val) : 0);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(sumNumbers(t1));
    }
}
