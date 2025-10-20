import java.util.*;

class Solution {
    int n, ans;
    int[] info;
    List<Integer>[] children;
    boolean[] visited;

    public int solution(int[] info, int[][] edges) {
        this.n = info.length;
        this.info = info;
        children = new ArrayList[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int[] e : edges) children[e[0]].add(e[1]);
        visited = new boolean[1 << n];
        dfs(1);
        return ans;
    }

    void dfs(int mask) {
        if (visited[mask]) return;
        visited[mask] = true;

        int sheep = 0, wolf = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                if (info[i] == 0) sheep++;
                else wolf++;
            }
        }
        if (wolf >= sheep) return;
        if (sheep > ans) ans = sheep;

        List<Integer> next = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                for (int c : children[i]) if ((mask & (1 << c)) == 0) next.add(c);
            }
        }
        for (int c : next) dfs(mask | (1 << c));
    }
}
