import java.io.*;
import java.util.*;
 
public class Main {
   static int N;
   static int[] num;
   static int[] operator = new int[4];
   static int MIN = 1_000_000_001, MAX = -1_000_000_001;
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(in.readLine());
      StringTokenizer st = new StringTokenizer(in.readLine());
      num = new int[N];
      for(int i=0;i<N;i++) num[i] = Integer.parseInt(st.nextToken());
 
      st = new StringTokenizer(in.readLine());
      for(int i=0;i<4;i++) operator[i] = Integer.parseInt(st.nextToken());
 
      dfs(num[0],1);
 
      System.out.println(MAX+"\n"+MIN);
   }
   public static void dfs(int res, int cnt){
      if(cnt==N){
         MIN = Math.min(MIN,res);
         MAX = Math.max(MAX,res);
         return;
      }
 
      for(int i=0;i<4;i++){
         if(operator[i]==0) continue;
         operator[i]-=1;
         switch(i){
            case 0:
               dfs(res+num[cnt],cnt+1);
               break;
            case 1:
               dfs(res-num[cnt],cnt+1);
               break;
            case 2:
               dfs(res*num[cnt], cnt+1);
               break;
            case 3:
               if(res<0) dfs(-((-res)/num[cnt]) ,cnt+1);
               else dfs(res/num[cnt],cnt+1);
               break;
         }
         operator[i]+=1;
      }
   }
}