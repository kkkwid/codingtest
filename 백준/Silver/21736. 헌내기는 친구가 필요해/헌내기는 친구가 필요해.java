import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> queue = new ArrayDeque<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            graph[i] = br.readLine().toCharArray();
            if(queue.isEmpty()) {
                for(int j=0; j<M; j++) {
                    if(graph[i][j] == 'I') {
                        queue.addLast(new int[]{i, j});
                        break;
                    }
                }
            }
        }
        bfs();
        System.out.println(answer>0 ? answer : "TT");

    }
    
    static void bfs() {
        while(!queue.isEmpty()) {
            int[] tmp = queue.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) {
                    continue;
                }
                if(graph[nx][ny] != 'X' && !visited[nx][ny]) {
                    if(graph[nx][ny] == 'P') {
                        answer++;
                    }
                    visited[nx][ny] = true;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}