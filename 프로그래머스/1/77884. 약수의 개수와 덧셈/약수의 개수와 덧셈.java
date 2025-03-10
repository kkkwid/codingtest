class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<= right; i++){
            double num = Math.sqrt(i);
            if((int) Math.sqrt(i) == num) {
                answer -= i;
            }
            else {
                answer += i;
            }
        }
        return answer;
    }
}