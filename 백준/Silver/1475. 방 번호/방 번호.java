import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[9];
        for(int i = 0; i<s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num == 9){
                arr[6]++;
            } else {
                arr[num]++;
            }
        }
        if(arr[6] % 2 == 1){
            arr[6] =  arr[6]/2 + 1;
        } else {
            arr[6] = arr[6]/2;
        }
        Arrays.sort(arr);
        System.out.println(arr[8]);
    }
}
