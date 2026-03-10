import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i<m; i++){
            int target = arr2[i];
            int start = 0;
            int end = arr.length-1;
            int find = 0;
            while(start <= end) {
                int mid = (start + end) / 2;

               if(target < arr[mid]){
                   end = mid - 1;
                }
               else if(target > arr[mid]){
                   start = mid + 1;
               }
               else{
                   System.out.println("1");
                   find = 1;
                   break;
               }
            }
            if(find != 1){
                System.out.println("0");
            }
        }
    }
}