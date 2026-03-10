import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 1;
        int co = 1;
        for (int i = 0; i < k; i++) {
            count *= n;
            n -= 1;
        }
        for(int i = k; i>0; i--){
            co *= i;
        }
        System.out.println(count/co);
    }
}
