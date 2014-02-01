package question;

import java.util.*;
import beans.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class BinaryTreePostorderTraversal {
    public static ArrayList<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        postorderTraversalHelper(root,list);
        return list;
    }

    private static void postorderTraversalHelper(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        postorderTraversalHelper(root.left,list);
        postorderTraversalHelper(root.right,list);
        list.add(root.val);
    }

}
