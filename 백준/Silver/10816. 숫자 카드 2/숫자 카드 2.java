import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr,key)-lowerBound(arr,key)).append(' ');
        }
        System.out.println(sb);

    }
    private static int lowerBound(int[] arr, int key){
        int low = 0;
        int high = arr.length;

        while(low < high){
            int middle = (low+high)/2;

            if(key<=arr[middle]){
                high = middle;
            }
            else{
                low = middle +1;
            }
        }
        return low;
    }

    private static int upperBound(int[] arr, int key){
        int low = 0;
        int high = arr.length;

        while(low<high){
            int middle = (high+low)/2;

            if(key<arr[middle]){
                high = middle;
            }
            else{
                low = middle+1;
            }
        }
        return low;
    }
}
