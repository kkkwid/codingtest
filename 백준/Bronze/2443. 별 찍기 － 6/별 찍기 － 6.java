import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<=n; i++){//엔터

            for(int j=1; j<i; j++) {//띄어쓰기
                System.out.print(" ");
            }
            for(int k=(2*n)-(i*2-1); k>0; k--){//*
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
