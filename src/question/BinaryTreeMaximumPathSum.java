package question;

import beans.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class BinaryTreeMaximumPathSum {
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    private static int maxPathSumHelper(TreeNode root){
        if (root == null) return 0;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        max = Math.max(max,Math.max(root.val, Math.max(left + right + root.val, Math.max(left, right) + root.val)));
        return Math.max(root.val, Math.max(left+root.val, right+root.val));
    }



    public static void main(String[] args){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-2);
        n1.left = n2;
        n1.right = n3;
        System.out.println(maxPathSum(n1));
    }
}
