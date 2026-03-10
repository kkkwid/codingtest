import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int arrA[] = new int[A];
			int arrB[] = new int[B];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrA);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrB);
			int res = 0;
			for (int i = 0; i < A; i++) {
				int s = 0;
				int e = B-1;
				int ans = -1;
				
				while(s<=e) {
					int mid = (s+e)/2;
					if( arrA[i] <= arrB[mid] ) {
						e = mid - 1;
					} else {
						s = mid+1;
						ans = mid;
					}
					
				}
				res += ans+1;
			}
			System.out.println(res);
		}

	}
}