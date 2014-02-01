package question;

import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class ValidateBinarySearchTree {
    static TreeNode pre;
    public static boolean isValidBST(TreeNode root){
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(pre == null) pre = root;
        else if(root.val <= pre.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

}
