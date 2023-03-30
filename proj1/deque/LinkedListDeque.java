package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private class Node{
        public T item;
        Node prev;
        Node next;

        public Node(T item,Node prev,Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        sentinel.next = new Node(item,sentinel,sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = new Node(item,sentinel.prev,sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel;
        while (p.next!=sentinel){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(!isEmpty()){
            T item = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return item;
        }
        return null;
    }

    public T removeLast(){
        if(!isEmpty()){
            T item = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return item;
        }
        return null;
    }

    public T get(int index){
        if(!isEmpty() && index < size && index >= 0){
            Node p = sentinel.next;
            for(int i=0;i<index;i++){
                p = p.next;
            }
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index){
        if(index < 0){
            return null;
        }
        Node p = sentinel.next;
        return getRecursiveHelper(index,p);
    }

    public T getRecursiveHelper(int index,Node p){
        if(index == 0){
            return p.item;
        }
        return getRecursiveHelper(index-1,p.next);
    }
}
