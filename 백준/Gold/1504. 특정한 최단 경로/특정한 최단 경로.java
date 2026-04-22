import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int N;
    public static int E;
    public static HashSet<Integer> set = new HashSet<>();
    public static int[][] graph;
    public static int v1;
    public static int v2;
    public static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        for(int i = 1 ; i<= N  ; i++){
            for(int j = 1 ; j <=N ; j++){
                graph[i][j] =  MAX;
            }
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long a = dijkstra(1,v1);
        long b = dijkstra(v1, v2);
        long c = dijkstra(v2, N);

        long ans1 = a + b + c;

        long a1 = dijkstra(1, v2);
        long b1 = dijkstra(v2,v1);
        long c1 = dijkstra(v1, N);
        long ans2 = a1 + b1 + c1;

        if(ans1 >= MAX && ans2 >= MAX){
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(ans1, ans2));
        }
    }
    public static long dijkstra(int start , int end){
        Queue<Integer> queue = new LinkedList<>();
        long[] table = new long[N + 1];
        Arrays.fill(table, MAX);
        queue.add(start);
        table[start] = 0;
        while(!queue.isEmpty()){

            int cur = queue.poll();

            for(int child= 1 ; child <=N; child++){

                if(graph[cur][child] != MAX && table[child] > table[cur] + graph[cur][child]){
                    table[child] = table[cur] + graph[cur][child];
                    queue.add(child);
                }

            }
        }
        return table[end];
    }
}