package question;

import beans.*;

/**
 * Created by siren0413 on 1/31/14.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x){
        ListNode small = new ListNode(0);
        ListNode temp = small;
        ListNode big = new ListNode(0);
        big.next = head;
        head = big;
        while(head.next!=null){
            if(head.next.val < x){
                temp.next = head.next;
                head.next = head.next.next;
                temp = temp.next;
                continue;
            }
            head = head.next;
        }
        temp.next = big.next;
        return small.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = partition(n1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
