package question;

import beans.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
