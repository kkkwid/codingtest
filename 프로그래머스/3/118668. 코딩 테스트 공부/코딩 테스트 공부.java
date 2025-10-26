import java.util.Arrays;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp;
        int maxCop = cop;
        for (int[] problem : problems) { // (1)
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        if (alp == maxAlp && cop == maxCop) { // (2)
            return 0;
        }

        int[][] dp = new int[maxAlp + 2][maxCop + 2]; // (3)
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i < dp.length - 1; i++) { // (4)
            for (int j = cop; j < dp[0].length - 1; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); // (5)
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] problem : problems) { // (6)
                    if (i >= problem[0] && j >= problem[1]) { // (7)
                        int nextAlp = Math.min(i + problem[2], maxAlp);
                        int nextCop = Math.min(j + problem[3], maxCop);

                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}