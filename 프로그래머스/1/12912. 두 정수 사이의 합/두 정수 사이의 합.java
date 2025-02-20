class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long max = Math.max(a,b);
        long min = Math.min(a,b);
        long sum = 0;
        for(long i = min; i<=max; i++){
            sum += i;
        }
        return sum;
    }
}