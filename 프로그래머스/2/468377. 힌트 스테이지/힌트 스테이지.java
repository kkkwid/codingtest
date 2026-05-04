class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int bundleCount = n - 1;
        int answer = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << bundleCount); mask++) {

            int[] hintCount = new int[n];
            int total = 0;

            for (int i = 0; i < n; i++) {

                int use = hintCount[i];
                total += cost[i][use];

                if (i < bundleCount && (mask & (1 << i)) != 0) {
                    total += hint[i][0];

                    for (int j = 1; j < hint[i].length; j++) {
                        int target = hint[i][j] - 1;
                        if (hintCount[target] < n - 1) {
                            hintCount[target]++;
                        }
                    }
                }
            }

            answer = Math.min(answer, total);
        }

        return answer;
    }
}
