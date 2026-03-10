import java.io.*;
import java.util.*;
 
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 배열로 스택에 저장
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            // 스택이 없어질때가지 while
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] {i, top}); 
        }
    }
}    
