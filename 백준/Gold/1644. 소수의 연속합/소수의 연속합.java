import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean sosu[];
    static ArrayList<Integer>list = new ArrayList<>();
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        n = Integer.parseInt(br.readLine());
        sosu = new boolean[n+1];
        eratones();
        for(int i=2; i<=n; i++) {
            if(!sosu[i]) {
                list.add(i);
            }
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;
        
        while(true) {
            if(sum == n) {
                ans++;
                sum-=list.get(start++);
            }
            else if (sum > n) {
                sum-=list.get(start++);
            }
            else {
                if(end == list.size()) {
                    System.out.println(ans);
                    break;
                }
                sum+=list.get(end++);
            }
        }
        
    }
    public static void eratones() {
        sosu[1] = true;
        for(int i=2; i<=n; i++) {
            for(int j=i*2; j<=n; j+=i) {
                sosu[j] = true;
            }
        }
    }
}