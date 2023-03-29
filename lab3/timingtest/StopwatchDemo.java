package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class StopwatchDemo {
    /** Computes the nth Fibonacci number using a slow naive recursive strategy.*/
    private static int fib(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        AList<Double> times = new AList<>();
        //int fib41 = fib(41);
        int sum = 0;
        int n = 1;
        double timeInSeconds;
        for(int i=0;i<10000;i++){
            sum+=i;
            if(i == (int) Math.pow(2,n)){
                times.addLast(sw.elapsedTime());
                System.out.println(n);
                n+=1;
            }
        }
        for(int i=0;i<times.size();i++){
            System.out.println(times.get(i));
        }
        //double timeInSeconds = sw.elapsedTime();
        //System.out.println("The 50th fibonacci number is " + fib41);
        //System.out.println("Time taken to compute 41st fibonacci number: " + timeInSeconds + " seconds.");
    }
}
