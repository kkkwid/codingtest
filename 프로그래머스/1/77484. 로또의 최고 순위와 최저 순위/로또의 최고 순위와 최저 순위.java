class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int count = 7;
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCount++;
            }
            else {
                for(int j = 0; j< win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        count--;
                    }
                }
            }
        }
        
        switch(zeroCount){
            case 0: if(count == 7){
                answer[0] = 6; answer[1] = 6;
                }
                else {
                    answer[0] = count; answer[1] = count;
                }
                break;
            case 1: answer[0] = Math.abs(count-zeroCount); answer[1] = count;
                break;
            case 2: answer[0] = Math.abs(count-zeroCount); answer[1] = count;
                break;
            case 3: answer[0] = Math.abs(count-zeroCount); answer[1] = count;  
                break;
            case 4: answer[0] = Math.abs(count-zeroCount); answer[1] = count;
                break;
            case 5: answer[0] = Math.abs(count-zeroCount); answer[1] = count; 
                break;
            case 6: answer[0] = 1; answer[1] = 6;
                break;
        }
        return answer;
    }
}