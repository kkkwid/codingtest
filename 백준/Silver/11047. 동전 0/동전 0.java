import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 계산할 금액
        int[] coins = new int[N];
        for(int i =  0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0; // 필요한 동전의 개수

        for(int i = coins.length - 1; i >= 1; i--){
            if(K >= coins[i]){
                count += K / coins[i];
                K %= coins[i];
            }
        }
        System.out.println(count+K);
    }
}
