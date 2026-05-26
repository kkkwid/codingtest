import java.util.*;

class Solution {
    public class ResultData {
        public List<Integer> list;
        public int depth;

        public ResultData(List<Integer> list, int depth) {
            this.list = list;
            this.depth = depth;
        }
    }
    public List<List<Integer>> map = new ArrayList<>();

    public ResultData bfs(int leaf, int n) {
        boolean[] chk = new boolean[n + 1];
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(leaf);
        chk[leaf] = true;
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        while(true) {
            while (!q1.isEmpty()) {
                int cur = q1.poll();
                for (int next : map.get(cur)) {
                    if (chk[next]) continue;
                    chk[next] = true;
                    q2.add(next);
                }
            }

            if (q2.isEmpty())
                break;

            depth++;
            list = new ArrayList<>(q2);

            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        return new ResultData(list, depth);
    }

    public int solution(int n, int[][] edges) {
        for (int i = 0; i <= n; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            map.get(from).add(to);
            map.get(to).add(from);
        }

        int cand = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] chk = new boolean[n+1];

        q.add(1);
        chk[1] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (map.get(cur).size() == 1)
                cand = cur;
            for (int next : map.get(cur)) {
                if (chk[next]) continue;
                chk[next] = true;
                q.add(next);
            }
        }

        ResultData result1 = bfs(cand, n);
        if (result1.list.size() > 1)
            return result1.depth;

        ResultData result2 = bfs(result1.list.get(0), n);
        if (result2.list.size() > 1)
            return result2.depth;
        else
            return result2.depth-1;
    }
}