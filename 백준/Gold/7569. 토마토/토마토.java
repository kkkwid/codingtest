import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int M = Integer.parseInt(size[0]);
        int N = Integer.parseInt(size[1]);
        int H = Integer.parseInt(size[2]);

        int[] dy = { 0, 0, -1, 1, 0, 0 };
        int[] dx = { 0, 0, 0, 0, -1, 1 };
        int[] dz = { -1, 1, 0, 0, 0, 0 };

        int[][][] tomato = new int[H][N][M];
        int cnt = 0, days = 0;
        Queue<int[]> que = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                String[] row = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(row[m]);
                    if (tomato[h][n][m] == 1)
                        que.add(new int[] { h, n, m });
                    else if (tomato[h][n][m] == 0)
                        cnt++;
                }
            }
        }

        while (cnt > 0 && !que.isEmpty()) {
            for (int s = que.size(); s > 0; s--) {
                int[] cur = que.poll();

                for (int k = 0; k < 6; k++) {
                    int nz = cur[0] + dz[k];
                    int ny = cur[1] + dy[k];
                    int nx = cur[2] + dx[k];

                    if (ny < 0 || nx < 0 || nz < 0 || ny >= N || nx >= M || nz >= H || tomato[nz][ny][nx] != 0)
                        continue;

                    cnt--;
                    tomato[nz][ny][nx] = 1;
                    que.add(new int[] { nz, ny, nx });
                }
            }
            days++;
        }
        System.out.println(cnt == 0 ? days : -1);
    }
}
