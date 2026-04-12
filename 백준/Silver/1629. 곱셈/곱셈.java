import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(modularExponentiation(a, b, c));

    }

    public static long modularExponentiation(long a, long b, long c) {
        if (b == 0) {
            return 1; 
        }

        long half = modularExponentiation(a, b / 2, c);
        long result = (half * half) % c;

        if (b % 2 == 1) { 
            result = (result * a) % c;
        }

        return result;
    }
}