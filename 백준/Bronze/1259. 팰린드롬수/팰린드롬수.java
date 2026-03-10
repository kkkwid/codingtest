import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String N = br.readLine();

            if(N.equals("0")){
                break;
            }

            StringBuilder sb = new StringBuilder(N);

            String rev = sb.reverse().toString();

            if(N.equals(rev)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

    }
}
