package question;

import beans.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root){
        if(root == null) return;
        if(root.left!=null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode mostRight = root.right;
            while(mostRight.right!=null) mostRight = mostRight.right;
            mostRight.right = temp;
        }
        flatten(root.right);
    }



    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        flatten(n1);

        TreeNode temp = n1;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.right;
        }
    }


}
