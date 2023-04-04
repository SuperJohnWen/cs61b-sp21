import java.util.LinkedList;

public class executeMain {

    public static void main(String[] args) {
        AList<Integer> aList = new AList<>();
        aList.addLast(1);
        aList.addLast(2);
        aList.addLast(3);
        aList.addLast(4);
        aList.addFirst(5);
        System.out.println(aList.size());
        System.out.println(aList.toString());
    }
}
