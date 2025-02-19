class Solution {
    public String solution(int a, int b) {
        String[] answer = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int result = -1;
        int[] day = {31,29,31,30,31,30,31,31,30,31,30,31};
        for(int i = 0; i<a-1; i++){
            result += day[i];
        }
        result += b;
        String y = answer[(result%7)];
        
        return y;
    }
}