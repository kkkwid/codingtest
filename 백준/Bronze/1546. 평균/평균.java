import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double[] arr = new Double[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println(sum/arr[arr.length-1]*100/arr.length);

    }
}
