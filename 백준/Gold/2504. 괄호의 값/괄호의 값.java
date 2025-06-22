import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int count = 1;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                count *= 2;
            } else if(str.charAt(i) == '[') {
                stack.push(str.charAt(i));
                count *= 3;
            } else if(str.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(str.charAt(i-1) == '(') {
                    result += count;
                }
                stack.pop();
                count /= 2;
            } else if(str.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    result += count;
                }
                stack.pop();
                count /= 3;
            }
        }
        if(!stack.isEmpty()) {
            sb.append(0).append("\n");
        } else {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}