import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int []result;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int t=Integer.parseInt(br.readLine());
        result=new int[t];
        for(int i=0;i<t;i++){
            result[i]=0;
            int n=Integer.parseInt(br.readLine());
            backtracking(n,i);
            System.out.println(result[i]);
        }

    }

    public static void backtracking(int n,int order){
        if(n==0){
            result[order]++;
        }

        for(int i=1;i<=3;i++){ //1,2,3
            int chk=n-i;
            if(chk>=0)
            backtracking(n-i,order);
        }

    }
}