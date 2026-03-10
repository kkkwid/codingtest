import java.io.*;
import java.util.*;
public class Main{
    static int A,B;
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            visit = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs(A,B);
        }
    }
    
    static void bfs(int a, int b){
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{a,""});
        visit[a]=true;
        
        while(!q.isEmpty()){
            Object p[] = q.poll();
            int next = (int)p[0];
            String result = (String)p[1];
            
            if(next==b){
                System.out.println(result);
                return;
            }
            
            int D = (next*2) % 10000;
            if(!visit[D]){
                visit[D] = true;
                q.add(new Object[]{D,result+"D"});
            }
            
            int S = next == 0 ? 9999:next-1;
            if(!visit[S]){
                visit[S] = true;
                q.add(new Object[]{S,result+"S"});
            }
            
            int L = (next%1000*10) + (next/1000);
            if(!visit[L]){
                visit[L] = true;
                q.add(new Object[]{L,result+"L"});
            }
            
            int R = (next%10*1000) + (next/10);
            if(!visit[R]){
                visit[R] = true;
                q.add(new Object[]{R,result+"R"});
            }
        }
    }
}