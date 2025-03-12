import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] oil = new long[N];
        long[] load = new long[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N-1; i++){
            load[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            oil[i] = Integer.parseInt(st.nextToken());
        }
        long min = oil[0];
        long price = load[0] * min;

        for(int i = 1; i< N-1; i++) {
            if(min > oil[i]){
                min = oil[i];
            }
            price += load[i] * min;
        }
        System.out.println(price);
    }
}
