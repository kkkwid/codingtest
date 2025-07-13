import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0){ // while문을 계속 돌리고 n == 0 일때 종료
                break;
            }

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); // arr배열에 값을 하나씩 넣음
            }

            result = new int[6];
            visit = new boolean[n];
            
            sb.setLength(0);
            
            back(0,0);

            System.out.println(sb);

        }

    }

    /* 
        깊이가 6이 되면 result배열의 값을 하나씩 꺼내서 sb에 저장
    */
    static void back(int start, int depth) {
        if (depth == 6) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                back(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}