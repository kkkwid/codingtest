import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            long[] dp = new long[1001];
            dp[1] = dp[2] =dp[3] = 1;
            for(int j = 4; j<=k; j++){
                dp[j] = dp[j-2] + dp[j-3];
            }
            System.out.println(dp[k]);
        }
    }
}
