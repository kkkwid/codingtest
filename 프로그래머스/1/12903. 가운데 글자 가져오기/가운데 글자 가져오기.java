import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = s;
        int a = s.length();
        if(a % 2 == 1){
            answer = answer.substring(a/2,a/2+1);
            return answer;
        }
        else{
            answer = answer.substring(a/2-1,a/2+1);
            return answer;
        }
        
        
    }
}