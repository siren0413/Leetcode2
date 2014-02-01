package question;

import java.util.*;
import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(inorder.length == 0 || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i],i);
        return buildTreeHelper(preorder,inorder,0,inorder.length-1,0,map);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end, int preStart, Map<Integer,Integer> map){
        if(start > end) return null;
        int rootIndex = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTreeHelper(preorder,inorder,start,rootIndex-1,preStart+1,map);
        root.right = buildTreeHelper(preorder,inorder,rootIndex+1,end,preStart+1+(rootIndex-start),map);
        return root;
    }
}

