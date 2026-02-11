import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int col = maps.length;
        int row = maps[0].length;
        boolean[][] visited = new boolean[col][row];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        List<int[]> queue = new ArrayList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.remove(0);
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny});
                    maps[ny][nx] = maps[ny][nx] == 1 ? maps[y][x] + 1 : Math.min(maps[ny][nx], maps[y][x] + 1);
                    if (nx == row - 1 && ny == col - 1) break;
                }
            }
        }

        return maps[col - 1][row - 1] == 1 ? -1 : maps[col - 1][row - 1];
    }
}