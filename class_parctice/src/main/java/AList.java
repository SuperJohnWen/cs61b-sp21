/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    /** Creates an empty list. */
    private Item items[];
    private int size;
    public AList() {
        items = (Item []) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size == items.length){
            Item[] a = (Item[]) new Object[size * 2];
            System.arraycopy(items,0,a,0,size);
            items = a;
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
        Item last = getLast();
        items[size-1] = null;
        size = size-1;
        return last;
    }


    public void addFirst(Item x){
        Item[] a = (Item[]) new Object[size * 2];
        System.arraycopy(items,0,a,1,size);
        items = a;
        items[0] = x;
        size = size + 1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i=0;i<size;i++){
            string.append(items[i]).append(",");
        }
        return string.toString();
    }

}