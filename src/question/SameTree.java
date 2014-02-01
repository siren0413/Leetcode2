package question;

import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q== null ) return true;
        if( (p==null) || ( q== null) || (p.val!=q.val) ) return false;
        return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
