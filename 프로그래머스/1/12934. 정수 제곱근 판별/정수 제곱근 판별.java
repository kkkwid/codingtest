class Solution {
    public long solution(long n) {
        long answer = 0;
        long num =(long) Math.sqrt(n);
        
        if(Math.pow(num,2) == n){
            long num2 = ((num+1) * (num+1));
            return num2;
        }
        return -1;
    }
}