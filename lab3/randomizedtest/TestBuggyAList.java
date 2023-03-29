package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  public static void main(String[] args) {
      //testThreeAddThreeRemove();
      //randomizedTest();
  }

    public static void testThreeAddThreeRemove(){
      AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
      BuggyAList<Integer> buggyAList = new BuggyAList<>();

      aListNoResizing.addLast(4);
      buggyAList.addLast(4);
      aListNoResizing.addLast(5);
      buggyAList.addLast(5);
      aListNoResizing.addLast(6);
      buggyAList.addLast(6);

      assertEquals(aListNoResizing.size(),buggyAList.size());

      assertEquals(aListNoResizing.removeLast(),buggyAList.removeLast());
      assertEquals(aListNoResizing.removeLast(),buggyAList.removeLast());
      assertEquals(aListNoResizing.removeLast(),buggyAList.removeLast());



    }

    @Test
    public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> LB = new BuggyAList<>();
      int N = 5000;
      for(int i = 0;i < N;i += 1){
          int operationNumber = StdRandom.uniform(0,4);
          if(operationNumber == 0){
              int randVal = StdRandom.uniform(0,100);
              L.addLast(randVal);
              LB.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          }else if(operationNumber == 1){
              int size = L.size();
              int sizeLB = LB.size();
              System.out.println("LSize: " + size + "LBSize: " + sizeLB);
              assertEquals(size,sizeLB);
          }else if (operationNumber == 2) {
              if(L.size()>0 & LB.size()>0){
                  int Val = L.getLast();
                  int ValLB = LB.getLast();
                  assertEquals(Val,ValLB);
                  System.out.println("getLast(" + Val + ")" + " getLast(" + ValLB +")");
              }
          }else if(operationNumber == 3){
              if(L.size()>0 & LB.size()>0){
                  int Val = L.removeLast();
                  int ValLB = LB.removeLast();
                  assertEquals(Val,ValLB);
                  System.out.println("getLast(" + Val + ")" + " getLast(" + ValLB +")");
              }
          }
      }
    }
}

