import java.util.*;
public class Main {
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []number=new int[n+1];
        int count=0;
        for(int i=2;i<=n;i++){
            number[i]=i; 
        }

        for(int i=2;i<=n;i++) {
            for (int j = i; j <= n; j+=i) {
                if (number[j]>0) { 
                    number[j] = 0; 
                    count++;
                    if (count == k) {
                      System.out.print(j);
                    }
                }else if(number[j] == 0) { 
                    continue;
                }

            }
        }

    }
}