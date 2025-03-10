class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        for(long i = price; i<= price * count; i+=price){
            answer += i;
        }
        return answer > money ? answer-money : 0;
    }
}