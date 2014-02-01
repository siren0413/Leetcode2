package question;

import java.util.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class LRUCache {

    Map<Integer, ListNode> map;
    ListNode head, tail;
    int capacity, size;

    public LRUCache(int capacity){
        map = new HashMap<>(capacity);
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.size = size;
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        remove(map.get(key));
        insert(map.get(key));
        return map.get(key).val;
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            map.get(key).val = value;
            remove(map.get(key));
            insert(map.get(key));
        }else{
            if(size >= capacity){
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            ListNode newNode = new ListNode(key,value);
            map.put(key,newNode);
            insert(newNode);
        }
    }

    private void remove(ListNode node){
        if(node == null) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size --;
    }

    private void insert(ListNode node){
        if(node == null) return;
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
        size++;
    }

    private class ListNode {
        int key, val;
        ListNode next;
        ListNode pre;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            next = null;
            pre = null;
        }
    }




    public static void main(String[] args){
        LRUCache cache = new LRUCache(1);
        cache.set(2,1);
        cache.get(2);
        cache.set(3,2);
        cache.get(2);
        cache.get(3);
    }
}
