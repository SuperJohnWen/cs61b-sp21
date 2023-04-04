public class SLList {

    public static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }

        public void test(){

        }

    }

    private final IntNode headNode;
    private int size;

    /*public SLList(int x){
        headNode = new IntNode(63,null);
        headNode.next = new IntNode(x,null);
        size=1;
    }*/

    public SLList(){
        size = 0;
        headNode = new IntNode(63,null);
    }

    public int getFirst(){
        return headNode.next.item;
    }

    public void addFirst(int x){
        headNode.next = new IntNode(x,headNode.next);
        size+=1;
    }


    public int size(){
        return size;
    }



    public void addLast(int x){
        size+=1;
        IntNode p = headNode;

        while (p.next!=null){
                p = p.next;
        }
        p.next = new IntNode(x,null);

    }

    public int getLast(){
        IntNode p = headNode;
        while (p.next!=null){
            p = p.next;
        }
        return p.item;
    }


}
