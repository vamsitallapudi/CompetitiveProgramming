import java.util.LinkedList;
import java.util.*;

public class LRUCache {

    private Map<Integer, DLLNode> cache;
    private DLLNode first;
    private DLLNode last;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, DLLNode>();
        this.capacity = capacity;
        first = new DLLNode();
        last = new DLLNode();
        first.prev = null;
        first.next = last;
        last.prev = first;
        last.next = null;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return refreshKey(key);
        }
        return -1;
    }

    private int refreshKey(int key) {
        DLLNode node = cache.get(key);
        refreshNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLLNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            refreshNode(node);
        } else {
            node = new DLLNode(key, value);
            cache.put(key, node);
            pushFront(node);
            if (cache.size() > capacity) {
                DLLNode lastNode = removeLast();
                cache.remove(lastNode.key);
            }
        }
    }

    private void refreshNode(DLLNode node) {
        removeNode(node);
        pushFront(node);
    }

    // moves the node to front, i.e., first.next
    private void pushFront(DLLNode node) {
        node.next = first.next;
        node.prev = first;
        first.next.prev = node;
        first.next = node;
    }

    // removes the given node
    private void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // removes the last item
    public DLLNode removeLast() {
        DLLNode node = last.prev;
        removeNode(node);
        return node;
    }

    public class DLLNode {
        int key;
        int value;
        DLLNode prev;
        DLLNode next;

        public DLLNode() {
            prev = null;
            next = null;
            value = -1;
        }

        public DLLNode(int key, int value) {
            prev = null;
            next = null;
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));
    }
}