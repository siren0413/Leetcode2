package question;

import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class ConvertSortedListToBinarySearchTree {
    // O(ologn)
    public static TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }


    //O(n)
    static ListNode gHead;
    public static TreeNode sortedListToBST2(ListNode head){
        if(head == null) return null;
        gHead = head;
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return buildBST(0,len-1);
    }

    private static TreeNode buildBST(int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode left = buildBST(start,mid-1);
        TreeNode root = new TreeNode(gHead.val);
        gHead = gHead.next;
        TreeNode right = buildBST(mid+1,end);
        root.left = left; root.right = right;
        return root;
    }



    // test
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        TreeNode root = sortedListToBST2(n1);
        inorder(root);
    }

    private static void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
