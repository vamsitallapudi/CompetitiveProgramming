import java.util.HashMap;
import java.util.Map;

public class LRUCacheNew {


    private Map<Integer, DLLNode> cache;
    private DLLNode first;
    private DLLNode last;
    private int capacity;

    public LRUCacheNew(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        first = new DLLNode();
        last = new DLLNode();
        first.prev = null;
        first.next = last;
        last.prev = first;
        last.next = null;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            return refreshKey(key);
        }
        return -1;
    }

    private int refreshKey(int key) {
        DLLNode node = cache.get(key);
        refreshNode(node);
        return node.value;
    }

    private void refreshNode(DLLNode node) {
        removeNode(node);
        pushFront(node);
    }

    private void removeNode(DLLNode node) {
        node.prev.next = node.next.next;
        node.next.prev = node.prev;
    }

    private DLLNode removeLast() {
        DLLNode node = last.prev;
        removeNode(node);
        return node;
    }

    private void pushFront(DLLNode node) {
        node.next = first.next;
        node.prev = first;
        first.next.prev = node;
        first.next = node;
    }
    
    public void put(int key, int value) {
        DLLNode node;
        if(cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            refreshNode(node);
        } else {
            node = new DLLNode(key, value);
            cache.put(key, node);
            pushFront(node);
            if(cache.size() > capacity) {
                DLLNode lastNode = removeLast();
                cache.remove(lastNode.key);
            }
        }
    }

    /**
     * DLLNode
     */
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
            this.key = key;
            this.value = value;
            prev = next = null;
        }

        
        public DLLNode(int key, int value, DLLNode first, DLLNode last
        ) {
            this.key = key;
            this.value = value;
            prev = next = null;
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */