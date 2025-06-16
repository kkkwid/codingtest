import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        /* 1~ N까지 큐에 삽입 */
        for(int i =  1; i <= N; i++){
            q.offer(i);
        }
        sb.append("<");
        for(int i = 0; i< N-1; i++){
            int num = K-1;
            /* K-1만큼 큐 맨앞에있는걸 맨 뒤로 보냄 */
            while(num --> 0) {
                q.offer(q.poll());
            }
            /* while문을 마치고 난 뒤 맨 앞에 있는 숫자가 다음 순서 */
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        System.out.println(sb);

    }
}
