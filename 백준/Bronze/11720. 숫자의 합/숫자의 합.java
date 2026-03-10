import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int arr[] = new int[a];
        int total = 0;

        for(int i=0;i<a;i++){
            arr[i]= s.charAt(i)-'0';
            total += arr[i];
        }
        System.out.println(total);


    }
}
