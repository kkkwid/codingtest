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
        StringBuilder sb = new StringBuilder();

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
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.getLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    } else  {
                        sb.append(0).append("\n");
                    }
                    break;
                case "pop":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.pop()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}