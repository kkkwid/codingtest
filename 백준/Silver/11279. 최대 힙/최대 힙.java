import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()) sb.append(x);
                else sb.append(pq.poll());
                sb.append("\n");
            }
            else{
                pq.add(x);
            }
        }
        System.out.println(String.valueOf(sb));
    }
}