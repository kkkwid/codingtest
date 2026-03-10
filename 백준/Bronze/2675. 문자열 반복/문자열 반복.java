import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            String s = str[1];

            for(int j=0; j<s.length();j++){
                for(int k=0; k<a; k++){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
