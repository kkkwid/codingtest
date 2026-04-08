import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String infix = sc.next();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char now = infix.charAt(i);

            switch (now) {
                case '(':
                    stack.push(now);
                    break;
                case ')':
                    // '(' 연산자를 만날 때까지 빼준다.
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // 마지막에 못뺏던 '(' 연산자를 빼주기
                    break;
                case '*':
                case '/':
                case '+':
                case '-':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.push(now);
                    break;
                default:
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        sc.close();
    }

    static int priority(char operator) {

        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }

        return 0;
    }
}