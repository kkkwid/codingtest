import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = String.valueOf(n);
        
        int[] arr = new int[str.length()];
        
        for(int i = 0; i<str.length(); i++){
            arr[i] = str.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        String ss = "";
        
        for(int i = 0; i < arr.length; i++){
            ss += arr[arr.length-i-1];
        }
        answer = Long.parseLong(ss);
        
        
        return answer;
            
    }
}