import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++){
            String str = br.readLine();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                switch(ch){
                    case '<':
                        if(!leftStack.isEmpty()){
                            rightStack.push(leftStack.pop());
                        }
                        break;
                    case '>':
                        if(!rightStack.isEmpty()){
                            leftStack.push(rightStack.pop());
                        }
                        break;
                    case '-': if(!leftStack.isEmpty()){
                        leftStack.pop();
                    } break;
                    default: leftStack.push(ch); break;
                }
            }
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            StringBuilder sb = new StringBuilder();
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            System.out.println(sb);
        }
    }
}
