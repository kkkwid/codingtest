import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            int score = 0;
            int plus = 0;

            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'O'){
                    plus++;
                    score += plus;
                }else {
                    plus = 0;
                }
            }
            System.out.println(score);
        }
    }
}
