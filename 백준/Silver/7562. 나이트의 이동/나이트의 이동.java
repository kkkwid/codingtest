import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I;
    static int x1, x2, y1, y2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            I = Integer.parseInt(br.readLine());

            arr = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(arr[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x1, y1});
        visited[x1][y1] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0], ny = now[1];

            for(int i = 0; i < 8; i++){
                int ox = nx + dx[i], oy = ny + dy[i];
                if(ox >= 0 && ox < I && oy >= 0 && oy < I){
                    if(!visited[ox][oy]){
                        q.add(new int[] {ox, oy});
                        arr[ox][oy] = arr[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }
            }
        }
    }
}