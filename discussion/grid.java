import java.util.Arrays;

public class grid {

    public static  void fillGrid(int[]LL, int[] UR, int[][] S){
        int N = S.length;
        int kl, kr;
        kl = kr = 0;

        for(int i=0; i<N;i++){
            for(int j=0;j<N;j++){
                if(j<i){
                    S[i][j] = LL[kl];
                    kl++;
                }else if(j>i){
                    S[i][j] = UR[kr];
                    kr++;
                }
            }
        }
    }
}
