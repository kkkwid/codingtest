public class Solution {
    public long solution(int[][] land, int P, int Q) {
        int N = land.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                min = Math.min(min, land[i][j]);
                max = Math.max(max, land[i][j]);
            }
        }

        int lo = min;
        int hi = max + 1;
        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            long left = 0;
            long cur = 0;
            long right = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mid - 1 >= 0) {
                        left += (land[i][j] > mid - 1) ? (long)(land[i][j] - mid + 1) * Q : (long)(mid - 1 - land[i][j]) * P;
                    }
                    if (mid + 1 <= max) {
                        right += (land[i][j] > mid + 1) ? (long)(land[i][j] - mid - 1) * Q : (long)(mid + 1 - land[i][j]) * P;
                    }
                    cur += (land[i][j] > mid) ? (long)(land[i][j] - mid) * Q : (long)(mid - land[i][j]) * P;
                }
            }

            if (mid - 1 < min) {
                if (cur < right) hi = mid;
                else lo = mid;
            } else if (mid + 1 > max) {
                if (cur > left) hi = mid;
                else lo = mid;
            } else {
                if (cur <= left && cur <= right) {
                    lo = mid;
                    break;
                } else if (cur > left) {
                    hi = mid;
                } else
                    lo = mid;
            }
        }

        long result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += (land[i][j] > lo) ? (long)(land[i][j] - lo) * Q : (long)(lo - land[i][j]) * P;
            }
        }
        return result;
    }
}