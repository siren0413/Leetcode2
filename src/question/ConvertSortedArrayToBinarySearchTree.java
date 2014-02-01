package question;

import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] num){
        if(num.length == 0) return null;
        return sortedArrayToBSTHelper(num, 0, num.length-1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] num, int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHelper(num,start, mid-1);
        root.right = sortedArrayToBSTHelper(num,mid+1, end);
        return root;
    }




    public static void main(String[] args){
        int[] num = {1,2,3,4,5,6,7,8};
        TreeNode root = sortedArrayToBST(num);
        inorder(root);
    }

    private static void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
