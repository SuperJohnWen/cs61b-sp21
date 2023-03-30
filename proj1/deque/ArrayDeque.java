package deque;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
       items = (T[]) new Object[8];
       nextFirst = 1;
       nextLast = 2;
       size = 0;
    }
    @Override
    public void addFirst(T item) {
        if(size == items.length){
            resize(size*2);
        }
        items[nextFirst] = item;
        if(nextFirst-1<0){
            nextFirst = items.length-1;
        }
        else {
            nextFirst -=1;
        }
        size +=1;
    }

    @Override
    public void addLast(T item) {
        if(size == items.length){
            resize(size * 2);
        }
        items[nextLast] = item;
        if(nextLast+1 > items.length-1){
            nextLast = 0;
        }
        else {
            nextLast+=1;
        }
        size+=1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i=0;i<size;i++){
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        if((size <= items.length/4) && (items.length>15)){
            resize(items.length/2);
        }
        T item;
        if(nextFirst+1> items.length-1){
            item = items[0];
            items[0] = null;
            nextFirst = 0;
        }else {
            item = items[nextFirst+1];
            items[nextFirst+1] = null;
            nextFirst+=1;
        }
        size-=1;
        return item;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        if((size <= items.length/4) && (items.length>15)){
            resize(items.length/2);
        }
        T item;
        if(nextLast-1<0){
            item = items[items.length-1];
            items[items.length-1] = null;
            nextLast = items.length-1;
        }
        else {
            item = items[nextLast-1];
            items[nextLast-1] = null;
            nextLast -=1;
        }
        size-=1;
        return item;
    }

    @Override
    public T get(int index) {
        if(!isEmpty() && index >= 0 && index < size){
            int current;
            if(nextFirst == items.length-1){
                current = 0;
            }
            else {
                current = nextFirst+1;
            }
            if(current + index > items.length-1){
                return items[current+index- items.length];
            }
            return items[current+index];
        }
        else {
            return null;
        }
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        for(int i=0;i<size;i++){
            a[i] = get(i);
        }
        items = a;
        nextFirst = items.length-1;
        nextLast = size;
    }
}
