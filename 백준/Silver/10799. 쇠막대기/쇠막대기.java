import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int num = 0;
        int leftCount= 0;

        for (Character c : arr) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(stack.peek() == '(' && c == '(') {
                    leftCount++;
                    stack.push(c);
                } else if (stack.peek() == '(' && c == ')') {
                    num+=leftCount;
                    stack.push(c);
                } else if (stack.peek() == ')' && c == '(') {
                    stack.push(c);
                } else if(stack.peek() == ')' && c == ')') {
                    num++;
                    leftCount--;
                    stack.push(c);
                }
            }
        }
        System.out.println(num);
    }
}
