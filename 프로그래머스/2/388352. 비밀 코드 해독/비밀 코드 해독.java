import java.util.*;

public class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<Set<Integer>> querySets = new ArrayList<>();
        for (int[] arr : q) {
            Set<Integer> s = new HashSet<>();
            for (int x : arr) {
                s.add(x);
            }
            querySets.add(s);
        }

        List<Set<Integer>> candidates = new ArrayList<>();
        combination(1, n, 5, new ArrayList<>(), candidates);

        int count = 0;
        for (Set<Integer> candidate : candidates) {
            if (isValid(candidate, querySets, ans)) {
                count++;
            }
        }

        return count;
    }

    private void combination(int start, int n, int r,
                             List<Integer> current,
                             List<Set<Integer>> result) {
        if (current.size() == r) {
            result.add(new HashSet<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            combination(i + 1, n, r, current, result);
            current.remove(current.size() - 1);  
        }
    }
    private boolean isValid(Set<Integer> candidate,
                            List<Set<Integer>> querySets,
                            int[] ans) {
        for (int i = 0; i < querySets.size(); i++) {
            Set<Integer> tmp = new HashSet<>(candidate);
            tmp.retainAll(querySets.get(i));
            if (tmp.size() != ans[i]) {
                return false;
            }
        }
        return true;
    }
}