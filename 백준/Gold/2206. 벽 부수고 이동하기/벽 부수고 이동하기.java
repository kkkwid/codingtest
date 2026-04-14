import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] board;
    private static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.valueOf(row.charAt(j) - '0');
            }
        }
        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        visited = new int[2][n][m];

        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int z = node[0];
            int x = node[1];
            int y = node[2];

            if (x == n - 1 && y == m - 1) {
                return visited[z][x][y];
            }

            int distance = 4;
            for (int i = 0; i < distance; i++) {
                int nx = x + dx[i]; 
                int ny = y + dy[i]; 

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }

                if (board[nx][ny] == 0 && visited[z][nx][ny] == 0) {
                    visited[z][nx][ny] = visited[z][x][y] + 1;
                    queue.offer(new int[]{z, nx, ny});
                    continue;
                }
                if (board[nx][ny] == 1 && z == 0) {
                    visited[1][nx][ny] = visited[0][x][y] + 1;
                    queue.offer(new int[]{1, nx, ny});
                }
            }
        }
        return -1;
    }
}