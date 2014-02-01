package question;

import beans.ListNode;

/**
 * Created by siren0413 on 1/26/14.
 */
public class InsertionSortList {
    // iterator
    public static ListNode insertionSortList(ListNode head){
        if(head == null) return null;
        ListNode temp = head;
        while(temp != null){
            ListNode node = temp.next;
            while(node!=null){
                if(node.val < temp.val){
                    int t = node.val;
                    node.val = temp.val;
                    temp.val = t;
                }
                node = node.next;
            }
            temp = temp.next;
        }
        return head;
    }

    // recursive
    public static ListNode insertionSortList2(ListNode head){
        if(head == null) return null;
        ListNode temp = head.next;
        while(temp!=null){
            if(temp.val < head.val){
                int t = temp.val;
                temp.val = head.val;
                head.val = t;
            }
            temp = temp.next;
        }
        insertionSortList2(head.next);
        return head;
    }


    public static void main(String[] args){
        ListNode n1 = new ListNode(11);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = insertionSortList(n1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
