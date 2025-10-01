import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int n, m, count = 0;
	static ArrayList<Integer>[] aList;
	static ArrayList<Integer>[] bList;
	static int[] less;
	static int[] more;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		init();

		for (int i = 0; i < m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			aList[a].add(b);
			bList[b].add(a);
		}

		int mid = n >> 1;

		for (int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			less[i] = dfs(i, aList);
			visit = new boolean[n + 1];
			more[i] = dfs(i, bList);

			if (less[i] > mid || more[i] > mid) {
				count++;
			}
		}
		System.out.println(count);

	}

	private static int dfs(int index, ArrayList<Integer>[] list) {
		int sum = 0;
		visit[index] = true;
		for (int num : list[index]) {
			if (!visit[num]) {
				visit[num] = true;
				sum += dfs(num, list) + 1;
			}
		}
		return sum;
	}

	private static void init() {
		aList = new ArrayList[n + 1];
		bList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			aList[i] = new ArrayList<>();
			bList[i] = new ArrayList<>();
		}
		less = new int[n + 1];
		more = new int[n + 1];
	}
}