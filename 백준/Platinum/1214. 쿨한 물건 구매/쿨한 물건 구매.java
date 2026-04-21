import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int D=sc.nextInt();
        int P=sc.nextInt();
        int Q=sc.nextInt();
        if(P<Q){
            int temp = P;
            P = Q;
            Q = temp;
        }
        int MIN= P;
        for(int i=0;i<=Math.min(D/P,Q);i++){
            MIN=Math.min(MIN, (Q-(D-P*i)%Q)%Q);
        }
        MIN = Math.min(MIN,(P-(D%P))%P);
        System.out.println(D+MIN);
    }
}