package question;

import beans.*;
import java.util.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(inorder,postorder,0,inorder.length-1,postorder.length-1,map);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end, int postEnd, Map<Integer, Integer> map){
        if(start > end) return null;
        int rootIndex = map.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTreeHelper(inorder,postorder,start,rootIndex-1,postEnd -1 -(end-rootIndex), map);
        root.right = buildTreeHelper(inorder,postorder,rootIndex+1,end,postEnd -1, map);
        return root;
    }


    public static void main(String[] args){
        int[] inorder = {5,4,3,2,1};
        int[] postorder = {1,2,3,4,5};
        TreeNode node = buildTree(inorder,postorder);
        inorder(node);
    }

    private static void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
