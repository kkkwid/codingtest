import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++)graph[i] = new ArrayList<>();

        for(int i=0; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
        // 조건 때문에 정렬필수
        for(int i=1; i<=N ; i++) Collections.sort(graph[i]);

        //DFS
        visited = new boolean[N+1];
        DFS(V);
        sb.append('\n');

        //BFS
        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sb);
    }

    static void DFS(int v){
        visited[v] = true;
        sb.append(v).append(' ');

        for (int next : graph[v]){
            if(!visited[next])DFS(next);
        }
    }

    static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(' ');

            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

}