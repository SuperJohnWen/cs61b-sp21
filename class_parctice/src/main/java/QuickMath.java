import java.util.Arrays;

public class QuickMath {
    public static void multiplyBy3(int[] A){
        for(int x:A){
            x = x*3;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,3,3,4};
        multiplyBy3(A);
        System.out.println(Arrays.toString(A));
    }


}
