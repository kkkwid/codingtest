import java.util.*;  
import java.io.*;  
  
public class Main {  
    static StringTokenizer st;  
    public static void main(String[] args) throws Exception {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        int[][] arr = new int[n+1][4];  
        int[][] dp = new int[n+1][4];  
  
        for (int i = 1; i <= n; i++) {  
            st = new StringTokenizer(br.readLine());  
            arr[i][1] = Integer.parseInt(st.nextToken());  
            arr[i][2] = Integer.parseInt(st.nextToken());  
            arr[i][3] = Integer.parseInt(st.nextToken());  
        }  
  
        int min = Integer.MAX_VALUE;  
  
        for(int c = 1; c <= 3; c++) {  
            for (int i = 1; i <= 3; i++) {  
                if(c == i) dp[1][i] = arr[1][i];  
                else dp[1][i] = 1000 * 1000;  
            }  
  
            for (int i = 2; i <= n; i++) {  
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][2] , dp[i-1][3]);  
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][1] , dp[i-1][3]);  
                dp[i][3] = arr[i][3] + Math.min(dp[i-1][1] , dp[i-1][2]);  
            }  
  
            for (int i = 1; i <= 3; i++) {  
                if(c != i) min = Math.min(min, dp[n][i]);  
            }  
        }  
        System.out.println(min);  
    }  
}