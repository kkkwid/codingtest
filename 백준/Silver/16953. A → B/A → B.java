import java.io.*;
import java.util.*;
 
public class Main {
	static int N, M, S, P, K, A, B;
	static int answer = 0;
	static int[] arr;
	static int MAX = (int) 1e9 + 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		System.out.println( (answer = DFS(0, A, B)) >= MAX ? -1 : ( answer + 1));
	}
	
	static int DFS(int depth, long now, long target) {
		if(target == now) return 0;
		if(target < now) return MAX;
 
		int ret = MAX;
		ret = DFS(depth + 1, now * 2, target) + 1;
		
		ret = Math.min(ret, DFS(depth + 1, now * 10  + 1, target) + 1);
		return ret;
	}
}