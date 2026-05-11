import java.util.*;

class Solution {

    public long[] solution(int[] arr, long l, long r) {
        int n = arr.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + arr[i];

        long[] bps = new long[n + 1];
        for (int i = 0; i < n; i++) bps[i + 1] = bps[i] + (long) arr[i] * arr[i];

        long K = rangeSum(arr, prefix, bps, l, r);

        long len = r - l + 1;
        long totalLen = prefix[n];
        long C = (len <= totalLen) ? countK(arr, n, prefix, bps, len, K, totalLen) : 0;

        return new long[]{K, C};
    }

    private int[] posToPtr(int[] arr, long[] prefix, long pos) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (prefix[m + 1] < pos) lo = m + 1;
            else hi = m;
        }
        return new int[]{lo, (int)(pos - 1 - prefix[lo])};
    }

    private long rangeSum(int[] arr, long[] prefix, long[] bps, long l, long r) {
        return prefixSum(arr, prefix, bps, r) - prefixSum(arr, prefix, bps, l - 1);
    }

    private long prefixSum(int[] arr, long[] prefix, long[] bps, long x) {
        if (x <= 0) return 0;
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (prefix[m + 1] < x) lo = m + 1;
            else hi = m;
        }
        return bps[lo] + (x - prefix[lo]) * arr[lo];
    }

    private long countK(int[] arr, int n, long[] prefix, long[] bps,
                        long len, long K, long totalLen) {
        int[] lPtr = posToPtr(arr, prefix, 1);
        int[] rPtr = posToPtr(arr, prefix, len);
        int lai = lPtr[0], li = lPtr[1];
        int rai = rPtr[0], ri = rPtr[1];
        long wsum = rangeSum(arr, prefix, bps, 1, len);

        long C = 0;
        long maxS = totalLen - len + 1;
        long s = 1;

        while (s <= maxS) {
            int nextRai;
            long rightRemain;

            if (ri + 1 < arr[rai]) {
                nextRai = rai;
                rightRemain = arr[rai] - ri - 1;
            } else if (rai + 1 < n) {
                nextRai = rai + 1;
                rightRemain = arr[rai + 1];
            } else {
                nextRai = rai;
                rightRemain = 0;
            }

            long leftRemain = arr[lai] - li; 

            long steps = Math.min(Math.min(leftRemain, rightRemain), maxS - s + 1);
            if (steps == 0) steps = 1;

            long d = arr[nextRai] - arr[lai];
            long A = wsum - K;
            long B = A + (steps - 1) * d;

            if (d == 0) {
                if (A == 0) C += steps;
            } else {
                long minAB = Math.min(A, B), maxAB = Math.max(A, B);
                if (minAB <= 0 && 0 <= maxAB && A % d == 0) C += 1;
            }

            wsum += steps * d;
            s += steps;
            if (s > maxS) break;

            long liNew = li + steps;
            if (liNew >= arr[lai]) { lai++; li = (int)(liNew - arr[lai - 1]); }
            else li = (int) liNew;

            long riNew = ri + steps;
            if (riNew >= arr[rai]) { rai++; ri = (int)(riNew - arr[rai - 1]); }
            else ri = (int) riNew;
        }

        return C;
    }
}