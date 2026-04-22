import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] graph;
	static int[][][] dp;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		input();
		search();
		System.out.print(answer);
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		dp = new int[n+1][n+1][3];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void search() { 
		dp[1][2][0]=1;
		for(int i=1; i<=n; i++) {
			for(int j=2; j<=n; j++) {
				if(graph[i][j]==1) 
					continue;
				dp[i][j][0] = Math.max(dp[i][j][0],dp[i][j-1][0] + dp[i][j-1][2]);
				dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1] + dp[i-1][j][2]);
				if(graph[i-1][j]==1 || graph[i][j-1]==1)
					continue;
				dp[i][j][2] = Math.max(dp[i][j][2], dp[i-1][j-1][0] + dp[i-1][j-1][1]+ dp[i-1][j-1][2]); 
			}
		}
		answer=dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
	}	
}