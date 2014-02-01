package question;

import beans.ListNode;

/**
 * Created by siren0413 on 1/26/14.
 */
public class SortList {
    public static ListNode sortList(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode slow = head, fast = head.next; // fast = head.next why? because we need the slow to be the one before mid.
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(left!=null && right!=null){
            if(left.val <= right.val){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left==null?right:left;
        return head.next;
    }


// test
    public static void main(String[] args){
        ListNode n1 = new ListNode(11);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(10);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(20);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = sortList(n1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }


}
