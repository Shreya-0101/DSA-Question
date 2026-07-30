import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;

            remove(node);
            add(node);

        } else {

            Node node = new Node(key, value);

            map.put(key, node);
            add(node);

            if (map.size() > capacity) {

                Node lru = head.next;

                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void remove(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {

        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
}