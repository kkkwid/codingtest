import java.io.*;
import java.util.*;
public class Main{
    static int N,M,A,B;
    static ArrayList<Integer> arr[];
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N + 1]; 
        for(int i=1;i<=N;i++){
            arr[i]=new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
            arr[B].add(A);
        }
        
        int result=Integer.MAX_VALUE;
        int who = 0;
        for(int i =1; i<=N; i++){
            if(bfs(i)<result){
                result = bfs(i);
                who = i;
            }
        }
        
        System.out.println(who);
    }
    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[N+1];
        visit[start] = true;
        q.add(new int[] {start,0});
        
        int sum =0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0; i<arr[p[0]].size();i++){
                int next = arr[p[0]].get(i);
                if(!visit[next]){
                    visit[next] = true;
                    q.add(new int[]{next, p[1]+1});
                    sum += p[1]+1;
                }
            }
        }
        return sum;
        
    }
}