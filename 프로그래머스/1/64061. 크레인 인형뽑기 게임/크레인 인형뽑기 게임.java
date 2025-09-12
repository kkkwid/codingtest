import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> dolls = new Stack<>(); 
        
        for(int move : moves){
            for(int i=0;i<board.length;i++){
                int doll = board[i][move-1];
                board[i][move-1] = 0;
                if(doll != 0){
                    if(dolls.empty()) dolls.push(doll);
                    else if(doll != dolls.peek()) {dolls.push(doll); }
                    else { dolls.pop(); answer += 2;} 
                    break;
                }
            }
        }
        
        return answer;
    }
}