public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r){
        this.first = f;
        this.rest = r;
    }

    public static void evenOdd(IntList lst){
        if(lst == null || lst.rest == null ){
            return;
        }
        IntList oddList = lst;
        IntList evenList = lst.rest;
        IntList second = lst.rest;
        while (oddList.rest!= null && evenList.rest != null){
            oddList.rest = evenList.rest;
            evenList.rest = oddList.rest.rest;
            evenList = evenList.rest;
            oddList = oddList.rest;
        }
        oddList.rest = second;
    }

    public static IntList[] partition(IntList lst, int k){
        IntList[] array = new IntList[k];
        int index = 0;
        while (lst != null){
            IntList prevAtIndex = array[index];
            IntList next = lst.rest;
            array[index] = lst;
            array[index].rest = prevAtIndex;
            lst = next;
            index = (index+1) % array.length;
        }
        return array;
    }
}
