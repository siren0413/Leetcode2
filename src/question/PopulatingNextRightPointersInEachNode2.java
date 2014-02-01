package question;

import beans.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class PopulatingNextRightPointersInEachNode2 {
    public static void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode head = root;
        while(head!=null){
            TreeLinkNode subList = new TreeLinkNode(0);
            TreeLinkNode temp = subList;
            while(head!=null){
                if(head.left!=null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right!=null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = subList.next;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(2);
        TreeLinkNode n2 = new TreeLinkNode(1);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(0);
        TreeLinkNode n5 = new TreeLinkNode(7);
        TreeLinkNode n6 = new TreeLinkNode(9);
        TreeLinkNode n7 = new TreeLinkNode(1);
        TreeLinkNode n8 = new TreeLinkNode(2);
        TreeLinkNode n9 = new TreeLinkNode(1);
        TreeLinkNode n10 = new TreeLinkNode(0);
        TreeLinkNode n11 = new TreeLinkNode(8);
        TreeLinkNode n12 = new TreeLinkNode(8);
        TreeLinkNode n13 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        n10.left = n13;
        connect(n1);
        inorder(n1);
    }

    private static void inorder(TreeLinkNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.println("node:" + node.val + " node.next:" + (node.next == null ? null : node.next.val));
        inorder(node.right);
    }

}
