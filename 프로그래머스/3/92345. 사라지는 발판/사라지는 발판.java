class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    int[][] board;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1])[1];
    }

    int[] dfs(int ax, int ay, int bx, int by) {
        if (board[ax][ay] == 0) return new int[]{0, 0};
        boolean canMove = false;
        int win = Integer.MAX_VALUE;
        int lose = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = ax + dx[dir];
            int ny = ay + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 0) continue;
            canMove = true;
            board[ax][ay] = 0;
            int[] res = dfs(bx, by, nx, ny);
            board[ax][ay] = 1;
            if (res[0] == 0) win = Math.min(win, res[1] + 1);
            else lose = Math.max(lose, res[1] + 1);
        }
        if (!canMove) return new int[]{0, 0};
        if (win != Integer.MAX_VALUE) return new int[]{1, win};
        return new int[]{0, lose};
    }
}
