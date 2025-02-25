import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        Stack<String> stack = new Stack<>();
        for(int i = 0; i< participant.length; i++){
            stack.push(participant[i]);
        }
        
        for(int i = completion.length-1; i>=0; i--){
            if(stack.peek().equals(completion[i])){
                stack.pop();
            }
        }
        
        return stack.peek();
    }
}