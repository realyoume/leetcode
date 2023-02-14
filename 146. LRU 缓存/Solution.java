import java.util.*;

class LRUCache {

    class DLinkedNode {
        Integer key;
        Integer val;

        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(){};

        public DLinkedNode(Integer key, Integer val){
            this.key = key;
            this.val = val;
        }
    }
    Integer capacity;
    DLinkedNode head;
    DLinkedNode tail;

    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }

        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            node = new DLinkedNode(key, value);

            cache.put(key, node);
            addToHead(node);
            if (cache.size() > capacity){
                DLinkedNode temp = tail.prev;

                removeNode(temp);

                cache.remove(temp.key);
            }
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

public class Solution {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);
        lRUCache.put(1, 5); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(1, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(2);
        lRUCache.get(4);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
