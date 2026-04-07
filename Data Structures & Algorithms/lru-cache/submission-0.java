class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int k,int v){
            key=k;
            value=v;
        }
    }
    HashMap<Integer,Node> map=new HashMap<>();
    Node head=new Node(0,0),tail=new Node(0,0);
    int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    void remove(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
    void addToHead(Node n){
        n.next=head.next;
        n.prev=head;
        head.next.prev=n;
        head.next=n;
    }
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node n=map.get(key);
        remove(n);
        addToHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.value=value;
            remove(n);
            addToHead(n);
        }
        else{
            if(map.size()==cap){
                Node n=tail.prev;
                remove(n);
                map.remove(n.key);
            }
            Node n=new Node(key,value);
            map.put(key,n);
            addToHead(n);
        }
    }

}
