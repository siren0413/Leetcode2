package question;

import beans.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class ReorderList {
    public static void reorderList(ListNode head){
        if(head == null) return;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        mid = reverseList(mid,null);
        while(head!=null && mid!=null){
            ListNode nextMid = mid.next;
            mid.next = head.next;
            head.next = mid;
            head = head.next.next;
            mid = nextMid;
        }
    }

    private static ListNode reverseList(ListNode head, ListNode pre){
        if(head == null) return pre;
        ListNode temp = head.next;
        head.next = pre;
        return reverseList(temp, head);
    }


    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        //n3.next = n4;
        reorderList(n1);
        while(n1!=null){
            System.out.println(n1.val);
            n1= n1.next;
        }
    }

}
