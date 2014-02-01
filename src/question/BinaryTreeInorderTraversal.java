package question;

import beans.TreeNode;
import java.util.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class BinaryTreeInorderTraversal {
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            // left
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            // mid
            if(stack.isEmpty()) break;
            root = stack.pop();
            list.add(root.val);
            // right
            root = root.right;
        }
        return list;
    }
}
