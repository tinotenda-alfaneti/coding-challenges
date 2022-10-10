class LRUCache {
    
 class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) {
          this.key = key;
          this.value = value;
        }
  }
  
  Node head = new Node(0, 0), tail = new Node(0, 0);
  HashMap<Integer, Node> cacheStorage = new HashMap<>();
  int storageCap;
  
  public LRUCache(int capacity) {
    storageCap = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if(cacheStorage.containsKey(key)) {
      Node node = cacheStorage.get(key);
      remove(node);
      add(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if(cacheStorage.containsKey(key)) {
      remove(cacheStorage.get(key));
    }
    if(cacheStorage.size() == storageCap) {
      remove(tail.prev);
    }
    add(new Node(key, value));
  }
    
    
  private void remove(Node node) {
    cacheStorage.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
  
  private void add(Node node){
    cacheStorage.put(node.key, node);
    Node headNext = head.next;
    head.next = node;
    node.prev = head;
    headNext.prev = node;
    node.next = headNext;
  }
  
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */