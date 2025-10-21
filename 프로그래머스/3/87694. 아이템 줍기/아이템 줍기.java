import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int SIZE = 102;
        int[][] board = new int[SIZE][SIZE];
        for (int[] r : rectangle) {
            int x1 = r[0]*2, y1 = r[1]*2, x2 = r[2]*2, y2 = r[3]*2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }
        for (int[] r : rectangle) {
            int x1 = r[0]*2, y1 = r[1]*2, x2 = r[2]*2, y2 = r[3]*2;
            for (int x = x1+1; x < x2; x++) {
                for (int y = y1+1; y < y2; y++) {
                    board[x][y] = 0;
                }
            }
        }
        int sx = characterX*2, sy = characterY*2, ex = itemX*2, ey = itemY*2;
        int[][] dist = new int[SIZE][SIZE];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        dist[sx][sy] = 1;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ex && cur[1] == ey) return (dist[ex][ey]-1)/2;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
                if (board[nx][ny] != 1 || dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return 0;
    }
}
