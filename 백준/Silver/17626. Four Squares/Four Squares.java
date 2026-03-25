import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] DP = new int[n+1];
        DP[1] = 1;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;	
            for(int j=1;j * j <= i;j++){
                int index = i - j * j;
                min = Math.min(min, DP[index]);
            }
            DP[i] = ++min;	
        }
        bw.write(DP[n] + "");	
        bw.flush();		
        bw.close();
        br.close();
    }
}