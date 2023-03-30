package deque;

public class test {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.addLast(2);
        arrayDeque.addLast(1);
        arrayDeque.addLast(7);
        arrayDeque.addFirst(8);
        arrayDeque.removeLast();
        arrayDeque.printDeque();

    }
}
