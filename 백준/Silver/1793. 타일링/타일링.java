import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine();
            if(str == null) break;
            int n =  Integer.parseInt(str);
            BigInteger[] arr = new BigInteger[251];
            arr[0] = new BigInteger("1");
            arr[1] = new BigInteger("1");
            arr[2] = new BigInteger("3");
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 2].multiply(BigInteger.TWO).add(arr[i - 1]);
            }
            System.out.println(arr[n]);

        }
    }
}
