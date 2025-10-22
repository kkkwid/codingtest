class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        String color = board[h][w];
        int count = 0;
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            if (nh >= 0 && nh < n && nw >= 0 && nw < n && board[nh][nw].equals(color)) count++;
        }
        return count;
    }
}
