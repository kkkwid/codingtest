import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> naturalQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String comm = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (comm.equals("I")) {
               naturalQueue.add(num);
               reverseQueue.add(num);
            } else {
               if (num == 1 && !reverseQueue.isEmpty()) {
                   int pollNum = reverseQueue.poll();
                   naturalQueue.remove(pollNum);
               } else if (num == -1 && !naturalQueue.isEmpty()) {
                   int pollNum = naturalQueue.poll();
                   reverseQueue.remove(pollNum);
               }
            }
        }
        
        int[] answer = {0, 0};
        if (!naturalQueue.isEmpty() && !reverseQueue.isEmpty()) {
            answer[0] = reverseQueue.poll();
            answer[1] = naturalQueue.poll();
        }
        return answer;
    }
}