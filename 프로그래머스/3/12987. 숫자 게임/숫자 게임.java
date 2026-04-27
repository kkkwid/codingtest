import java.util.*;

class Solution {
    
    private static PriorityQueue<Integer> pqA = new PriorityQueue<>();
    private static PriorityQueue<Integer> pqB = new PriorityQueue<>();
    private static int Answer;
    
    public int solution(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        
        for (int i = 0; i < A.length; i++) {
            int nowA = pqA.poll();
            
            while (!pqB.isEmpty()) {
                int nowB = pqB.poll();
                if (nowA < nowB) {
                    Answer++;
                    break;
                }
            }
        }
        
        return Answer;
    }
}