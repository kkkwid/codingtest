import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();
    static boolean[] visited;
    static int[] time;
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        time = new int[100_001];
        visited = new boolean[100_001];
        System.out.println(bfs());
    }
    static int bfs() {
        queue.addLast(N);
        visited[N] = true;
        while(!queue.isEmpty()) {
            int pos = queue.removeFirst();
            if(pos == K) {
                return time[pos];
            }
            if(pos-1 >= 0 && pos-1 < 100_001 && !visited[pos-1]) {
                time[pos-1] = time[pos] + 1;
                visited[pos-1] = true;
                queue.addLast(pos-1);
            }
            if(pos+1 >= 0 && pos+1 < 100_001 && !visited[pos+1]) {
                time[pos+1] = time[pos] + 1;
                visited[pos+1] = true;
                queue.addLast(pos+1);
            }
            if(pos*2 >= 0 && pos*2 < 100_001 && !visited[pos*2]) {
                time[pos*2] = time[pos] + 1;
                visited[pos*2] = true;
                queue.addLast(pos*2);
            }
        }
        return -1;
    }
}