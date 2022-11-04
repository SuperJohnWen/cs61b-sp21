package Dog;

public class Fib {
    public static void main(String[] args) {
        int fib = fib(2,0,0,1);
        System.out.println(fib);
    }

    public static int fib(int n, int k, int f0, int f1){
        if(n == k){
            return f0 ;
        }
        else{
            return fib(n,k+1,f1,f0+f1);
        }
    }
}
