package deque;


public class test {
    public static void main(String[] args) {
//        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//        arrayDeque.addFirst(3);
//        arrayDeque.addFirst(4);
//        arrayDeque.addFirst(5);
//        arrayDeque.addLast(2);
//        arrayDeque.addLast(1);
//        arrayDeque.addLast(7);
//        arrayDeque.addFirst(8);
//        arrayDeque.printDeque();

        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        for(int i=0;i<10;i++){
            deque1.addLast(i);
        }
        deque2 = deque1;

        System.out.println(deque1.equals(deque2));

//        Comparator<Integer> cmp = new Comparator<>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) {
//                    return 1;
//                } else if (o1 < o2) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        };
//
//        MaxArrayDeque mad1 = new MaxArrayDeque(cmp);
//
//        int n = 99;
//
//        for (int i = n; i >= 0; i--) {
//            mad1.addFirst(i);
//        }
//
//        System.out.println(mad1.max());
//        System.out.println(mad1.max(cmp));
//
//        Comparator<String> cmp2 = new Comparator<>() {
//            //重写排序方法
//            @Override
//            public int compare(String strA, String strB) {
//                return strA.compareTo(strB);
//            }
//        };
//
//        MaxArrayDeque mad2 = new MaxArrayDeque(cmp2);
//
//        mad2.addFirst("front");
//        mad2.addLast("middle");
//        mad2.addLast("back");
//
//        System.out.println(mad2.max());
//        System.out.println(mad2.max(cmp2));
    }
}
