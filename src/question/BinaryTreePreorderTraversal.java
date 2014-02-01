package question;

import java.util.*;
import beans.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class BinaryTreePreorderTraversal {
    public static ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        preorderTraversalHelper(root,list);
        return list;
    }

    private static void preorderTraversalHelper(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preorderTraversalHelper(root.left, list);
        preorderTraversalHelper(root.right,list);
    }
}
