import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mul = 1;
        for(int i= 0;i<3; i++){
            int n = Integer.parseInt(br.readLine());
            mul *= n;
        }

        String N = String.valueOf(mul);

        for(int j=0;j<10; j++){
            int count = 0;
            for(int k=0;k<N.length();k++){
                if((N.charAt(k)-'0')==j){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
