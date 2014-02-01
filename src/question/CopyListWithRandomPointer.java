package question;

import beans.*;
import java.util.*;

/**
 * Created by siren0413 on 1/27/14.
 */
public class CopyListWithRandomPointer {
    // method 1: only clone node and random pointer, let a dummy head to connect node's next.
    public static RandomListNode copyRandomList(RandomListNode head){
        if(head == null) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode temp = dummyHead;
        while(head!=null){
            // copy node
            RandomListNode cloned = null;
            if(map.containsKey(head)){
                cloned = map.get(head);
            }else{
                cloned = new RandomListNode(head.label);
                map.put(head,cloned);
            }
            temp.next = cloned;
            // copy node's random
            if(map.containsKey(head.random)){
                cloned.random = map.get(head.random);
            }else if(head.random!=null){
                RandomListNode random = new RandomListNode(head.random.label);
                cloned.random = random;
                map.put(head.random, random);
            }
            head = head.next;
            temp = temp.next; // node's next is connected by dummy
        }
        return dummyHead.next;
    }

    // method 2: clone node, next, and random pointer.
    public static RandomListNode copyRandomList2(RandomListNode head){
        if(head == null) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode clonedHead = null;
        while(head!=null){
            // copy node
            RandomListNode cloned = null;
            if(map.containsKey(head)){
                cloned = map.get(head);
            }else{
                cloned = new RandomListNode(head.label);
                map.put(head,cloned);
            }
            // copy node's next
            if(map.containsKey(head.next)){
                cloned.next = map.get(head.next);
            }else if(head.next!=null){
                RandomListNode node = new RandomListNode(head.next.label);
                cloned.next = node;
                map.put(head.next,node);
            }
            // copy node's random
            if(map.containsKey(head.random)){
                cloned.random = map.get(head.random);
            }else if(head.random!=null){
                RandomListNode random = new RandomListNode(head.random.label);
                cloned.random = random;
                map.put(head.random, random);
            }
            if(clonedHead == null) clonedHead = cloned;
            head = head.next;
        }
        return clonedHead;
    }

}
