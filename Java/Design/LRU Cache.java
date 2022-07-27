class LRUCache {
    
    // you also need to keep track of key along with
    // its value because by doing so you can remove entry for key
    // on the reference of value that is if you are deleting least frequently 
    // element then you should also delete its corresponding key from the map
    
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;
    int size;
    
    private Node createNewNode(int key, int value) {
        Node newNode = new Node(key, value);
        return newNode;
    }
    
    private void insertAtFront(Node curr_node) {
        curr_node.next = head.next;
        head.next.prev = curr_node;
        curr_node.prev = head;
        head.next = curr_node;
    }
    
    private void deleteNode(Node curr_node) {
        curr_node.next.prev = curr_node.prev;
        curr_node.prev.next = curr_node.next;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr_node = map.get(key);
            int result = curr_node.val;
            deleteNode(curr_node);
            insertAtFront(curr_node);

            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)) {
            Node curr_node = map.get(key);
            curr_node.val = value;
            deleteNode(curr_node);
            insertAtFront(curr_node);
        }
        else {
            Node curr_node = createNewNode(key, value); // creating new Node
            map.put(key, curr_node); // mapping values

            if(size < capacity) {
                insertAtFront(curr_node);
                size++;
            }
            else {
                map.remove(tail.prev.key); // deleting entry first
                deleteNode(tail.prev); // deleting corresponding node as well
                insertAtFront(curr_node); // insert new node at the front of the list
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
