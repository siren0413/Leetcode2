package question;

import beans.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class LinkedListCycle2 {
    public static ListNode detectCycle(ListNode head){
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
