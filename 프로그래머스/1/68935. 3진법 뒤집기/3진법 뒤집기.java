import java.util.*;
class Solution {
    public int solution(int n) {
        Queue<Integer> result = new LinkedList<>();
        while(n!= 0){
            int temp = n;
            result.add(temp % 3);
            n /= 3;
        }
        int sum = 0;
        
        for(int i = result.size()-1; i>=0; i--){
            sum += result.poll() * (int) Math.pow(3,i);
        }
        
        return sum;
    }
}