import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        int num = 1;

        for(int i = 0; i< N; i++) {
            int K = Integer.parseInt(br.readLine());
            for( ; num <= K; num++) {
                stack.push(num);
                sb.append("+").append("\n");
            }
            if(stack.peek() == K) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                flag = true;
            }
        }

        if(flag){
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }

    }
}
