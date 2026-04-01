import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Main {

    static int N,K;
    static int time[];
    static int dp[];
    static int indegree[];
    static ArrayList<Integer> edges[];
    static int target;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        for(int t=0; t<test_case; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N+1];
            dp = new int[N+1];
            edges = new ArrayList[N+1];
            indegree = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
            {
                edges[i] = new ArrayList<>();
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<K; i++)
            {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                edges[from].add(to);
                indegree[to]++;
            }

            target = Integer.parseInt(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();

            for(int i=1; i<=N; i++)
            {
                if(indegree[i] == 0)
                {
                    q.add(i);
                    dp[i] = time[i];
                }
            }

            while (!q.isEmpty())
            {
                int cur = q.poll();

                for(int i=0; i<edges[cur].size(); i++)
                {
                    int next = edges[cur].get(i);
                    dp[next] = Math.max(dp[next], dp[cur] + time[next]);
                    indegree[next]--;

                    if(indegree[next] == 0)
                    {
                        q.add(next);
                    }
                }
            }

            System.out.println(dp[target]);
        }
    }
}