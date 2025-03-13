import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 설탕배달
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr =  new int[N+1];
        Arrays.fill(arr,9999);
        if(N >= 3) arr[3] = 1;
        if(N >= 5) arr[5] = 1;

        for(int i = 6; i<=N;i++){
            // 3 이전 또는 5이전 인덱스의 봉지 개수 + 1
            // 9999가 아닌 값으로 처리하기 위해 Math.min 으로 확인
            arr[i] = Math.min(arr[i-3],arr[i-5]) + 1;
        }
        if (arr[N] >= 9999) {
            System.out.println(-1);
        }
        else System.out.println(arr[N]);
    }
}
