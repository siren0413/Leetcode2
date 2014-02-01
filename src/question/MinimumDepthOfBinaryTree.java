package question;

import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left==null && root.right==null) return 1;
        int min = Integer.MAX_VALUE;
        if(root.left!=null) min = Math.min(min,minDepth(root.left)+1) ;
        if(root.right!=null) min = Math.min(min,minDepth(root.right)+1);
        return min;
    }


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        TreeNode n10 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        //n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        n6.left = n10;
        System.out.println(minDepth(n1));
    }
}
