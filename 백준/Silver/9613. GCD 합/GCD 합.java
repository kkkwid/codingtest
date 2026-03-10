import java.util.*;

public class Main {

    public static int GCD(int a, int b){
        if(b == 0)
            return a;
        return GCD(b, a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0 ){
            long result = 0; 
            int[] nums = new int[101];
            int n = sc.nextInt();

            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }

            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    result+=GCD(nums[i], nums[j]);
                }
            }
            System.out.println(result);
        }

        sc.close();
    }
}