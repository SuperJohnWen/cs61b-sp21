import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

       /* //* CS61B Discussion 3 fill Grid
        int[] LL = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0 };
        int[] UR = { 11, 12, 13, 14, 15, 16, 17 ,18, 19, 20 };
        int[][] S = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };
        grid.fillGrid(LL,UR,S);
        for (int[] ints : S) {
            System.out.println(Arrays.toString(ints));
        }*/


        //* CS61B Discussion 3 Even Odd
        IntList lst = new IntList(1,null);
        lst = new IntList(2,lst);
        lst = new IntList(3,lst);
        lst = new IntList(4,lst);
        lst = new IntList(5,lst);
/*        IntList p = lst;
        IntList.evenOdd(lst);
        while (p!= null){
            System.out.print(p.first + " ");
            p = p.rest;
        }*/

        IntList[] array = IntList.partition(lst,2);
        for (IntList intList : array) {
            while (intList != null) {
                System.out.print(intList.first + "");
                intList = intList.rest;
            }
            System.out.println();
        }
    }
}
