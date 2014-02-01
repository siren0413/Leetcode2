package question;

import beans.*;

/**
 * Created by siren0413 on 1/30/14.
 */
public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int count = n - m +1, i = 1;
        while (i < m) {
            temp = temp.next;
            i++;
        }
        ListNode reverseStart = reverse(temp.next,null,temp.next,count);
        temp.next = reverseStart;
        head = dummy.next;
        dummy.next = null;
        return head;
    }

    private static ListNode reverse(ListNode head, ListNode pre, ListNode start, int k) {
        if (k == 0) {
            start.next = head;
            return pre;
        }
        ListNode temp = head.next;
        head.next = pre;
        return reverse(temp, head, start, k - 1);
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;
        n4.next = n5;
        ListNode head = reverseBetween(n1, 1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
