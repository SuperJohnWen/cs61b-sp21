import java.util.LinkedList;

public class executeMain {

    public static void main(String[] args) {
        SLList slList = new SLList();
        slList.addLast(15);
        System.out.println(slList.getFirst());
        System.out.println(slList.size());
        System.out.println(slList.getLast());

    }
}
