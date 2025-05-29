import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            switch(S) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
                case "front":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peek());
                    }
                    break;
                case "back":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(q.getLast());
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty()){
                        System.out.println(1);
                    } else  {
                        System.out.println(0);
                    }
                    break;
                case "pop":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(q.pop());
                    }
                    break;
            }
        }
    }
}