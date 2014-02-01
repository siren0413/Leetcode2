package question;

import beans.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root){
        if(root == null) return;
        if(root.left!=null) root.left.next = root.right;
        if(root.right!=null && root.next!=null) root.right.next= root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
