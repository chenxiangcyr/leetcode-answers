class Node {
    int key;
    int value;
    
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    HashMap<Integer, Node> map;
    int capicity;
    int count;
    
    // 构成一个双向链表
    Node head, tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        
        this.capicity = capacity;
        count = 0;
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        head.next = tail;
        head.pre = null;
        
        tail.pre = head;
        tail.next = null;
    }
    
    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            
            // 从当前位置移除，放到头部
            deleteNode(node);
            addToHead(node);
            
            return result;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        // 更新
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            
            // 从当前位置移除，放到头部
            deleteNode(node);
            addToHead(node);
        }
        // 加入
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            // 放到头部
            addToHead(node);
            
            // 没有达到capicity
            if (count < capicity) {
                count++;
            } else {
                // 移除队尾
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
