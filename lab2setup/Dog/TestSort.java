package Dog;

import java.util.Arrays;

public class TestSort {
    public static void testSort(){
        String[] input  = {"I", "have", "an", "egg"};
        String[] expect = {"I", "an", "egg", "have"};
        Sort.sort(input,0);
        org.junit.Assert.assertArrayEquals(expect,input);
        System.out.println(Arrays.toString(expect));
    }

    /** Test the Sort.findSmallest method */
    
    public static void main(String[] args) {
        testSort();
    }
}
