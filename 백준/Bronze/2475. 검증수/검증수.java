import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());
        int a4 = Integer.parseInt(st.nextToken());
        int a5 = Integer.parseInt(st.nextToken());

        a1 *= a1;
        a2 *= a2;
        a3 *= a3;
        a4 *= a4;
        a5 *= a5;

        int sum = a1+a2+a3+a4+a5;

        int div = sum % 10;

        System.out.println(div);
    }
}
