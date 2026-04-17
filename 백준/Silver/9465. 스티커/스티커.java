import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] sticker, DP;	
        for(int test_case = 0;test_case < T;test_case++){
            int N = Integer.parseInt(br.readLine());
            sticker = new int[2][N];
            DP = new int[3][N];
            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++)
                    sticker[i][j] = Integer.parseInt(st.nextToken());
            }
            DP[1][0] = sticker[0][0];
            DP[2][0] = sticker[1][0];
            for(int i=1;i<N;i++){
                DP[0][i] = Math.max(DP[1][i-1], DP[2][i-1]);
                DP[1][i] = Math.max(DP[0][i-1], DP[2][i-1]) + sticker[0][i];
                DP[2][i] = Math.max(DP[0][i-1], DP[1][i-1]) + sticker[1][i];
            }
            bw.write(Math.max(DP[1][N-1], DP[2][N-1]) + "\n");
        }
        bw.flush();	
        bw.close();
        br.close();
    }
}