class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length, m = board[0].length;
        int[][] acc = new int[n + 1][m + 1];
        for (int[] s : skill) {
            int val = (s[0] == 1 ? -s[5] : s[5]);
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            acc[r1][c1] += val;
            acc[r1][c2 + 1] -= val;
            acc[r2 + 1][c1] -= val;
            acc[r2 + 1][c2 + 1] += val;
        }
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= m; j++)
                acc[i][j] += acc[i][j - 1];
        for (int j = 0; j <= m; j++)
            for (int i = 1; i <= n; i++)
                acc[i][j] += acc[i - 1][j];
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] + acc[i][j] > 0) ans++;
        return ans;
    }
}
