import java.util.*;
 
class Solution {
    static final int MAX = 1_000_000;
    
    static int[][] edges;
    static int[] input, output;
    
    public int[] solution(int[][] edges) {
        this.edges = edges;
                        
        input = new int[MAX + 1];  
        output = new int[MAX + 1];  
        
        int maxNode = 0;
        for(int[] e : edges) {
            input[e[1]]++;
            output[e[0]]++;
            
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        
        int[] answer = new int[4];
               
        for(int i = 1 ; i <= maxNode ; i++) {
            if(input[i] == 0 && output[i] >= 2) { 
                answer[0] = i;
            }
            else if(input[i] > 0 && output[i] == 0) {
                answer[2]++;
            }
            else if(input[i] >= 2 && output[i] >= 2) { 
                answer[3]++;
            }
        }
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}