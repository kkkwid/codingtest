import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        
        for(int i = 1; i <= N; i++) {
            dq.add(i);
        }
        
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            //num이 맨 앞에 올때까지 while문
            while(dq.getFirst() != num) {
                /* 덱 안에 num 값을 찾고 어디로 갈지 정함 */
                if(dq.indexOf(num) <= (dq.size() / 2)) {
                    dq.addLast(dq.getFirst());
                    dq.removeFirst();
                }else {
                    dq.addFirst(dq.getLast());
                    dq.removeLast();
                }
                count++;
            }
            //num이 맨 앞이면 제거
            if(dq.getFirst() == num) {
                dq.removeFirst();
            }
        }
        System.out.println(count);
    }

}