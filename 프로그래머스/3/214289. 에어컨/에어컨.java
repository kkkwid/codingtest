import java.util.*;
class Solution {
    static final int MAX = 100 * 1000 + 1;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        t1 += 10; t2 += 10; int temp = temperature + 10;
        
        int [][] DP = new int [onboard.length][51];
        for(int i = 0; i < onboard.length; i++){
            Arrays.fill(DP[i], MAX);
        }
        DP[0][temp] = 0; 
        for(int i = 0; i < onboard.length - 1; i++){
            for(int j = 0; j <= 50; j++){
                if(onboard[i] == 1 && (j < t1 || t2 < j)) continue;
                DP[i+1][j] = Math.min(DP[i+1][j], DP[i][j] + b);
                if(j >= 1) DP[i+1][j-1] = Math.min(DP[i+1][j-1], DP[i][j] + a);
                if(j < 50) DP[i+1][j+1] = Math.min(DP[i+1][j+1], DP[i][j] + a);
                
                if(temp == j){   
                    DP[i+1][j] = Math.min(DP[i+1][j], DP[i][j]);
                }
                else if(temp > j && j < 50){ 
                    DP[i+1][j+1] = Math.min(DP[i+1][j+1], DP[i][j]);
                }
                else if(temp < j && j >= 1){ 
                    DP[i+1][j-1] = Math.min(DP[i+1][j-1], DP[i][j]);
                }
            }
        }
        int min = MAX;
        int last = onboard.length - 1;
        for(int i = 0; i <= 50; i++){
            if(onboard[last] == 1 && (i < t1 || t2 < i)) continue; 
            min = Math.min(min, DP[last][i]);
        }
        return min;
    }
}
