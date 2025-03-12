import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2]; // 회의 갯수 * (시작시간 /종료시간)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }
        Arrays.sort(time,(o1,o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int count = 0;
        int num = 0;
        for(int i = 0;  i < N; i++){
            if(time[i][0] >= num){
                count ++;
                num = time[i][1];
            }
        }
        System.out.println(count);
    }
}
