class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int num = cookie.length;
        
        for (int i = 0; i < num - 1; i++) {
            int leftSum = cookie[i];
            int rightSum = cookie[i + 1];
            
            int left = i;
            int right = i + 1;
            
            while (left >= 0 && right < num) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }
                
                if (leftSum <= rightSum && left > 0) {
                    left--;
                    leftSum += cookie[left];
                } else if (rightSum < leftSum && right < num - 1) {
                    right++;
                    rightSum += cookie[right];
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}