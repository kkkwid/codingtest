class Solution {
    public int solution(int n) {
        int answer = 1;
        int check;
        
        for(int i = 3; i<=n; i+=2){
            check = 1;
            for(int j = 2; j<=Math.sqrt(i); j++){
                if(i % j == 0){
                    check= 0; break;
                }
            }
            if(check == 1){
                answer++;
            }
        } 
        return answer;
    }
}

// 1 3 9 11 33 99
// 1 3 9 27 81
// 1 2 4 6 12 18 36 72
// 1 2 4 8 16 32 64
// 1 7 11 77
// 1 7 49