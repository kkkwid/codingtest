import java.util.*;
import java.io.*;
public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        BFS(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }

    }
    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int i : list[q]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = q;
                }
            }
        }
    }
}