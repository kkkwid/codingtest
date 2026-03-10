import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w= Integer.parseInt(st.nextToken()); 
        int l= Integer.parseInt(st.nextToken()); 

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        int count=0; 
        int bridgeWeight=0; 

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<w; i++){
            bridge.add(0);
        }

        while(!bridge.isEmpty()) {
            count++;
            bridgeWeight-=bridge.poll(); 
            if(!truck.isEmpty()){ 
                if(truck.peek()+bridgeWeight <= l) { 
                    bridgeWeight+=truck.peek();
                    bridge.offer(truck.poll()); 
                }else{ 
                    bridge.offer(0);
                }
            }
        }
        System.out.println(count);
    }
}