import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int start = 0;
        int end = 0; 
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 2){
                start = i;
                break;
            }
        }
        for(int j = arr.length-1; j>=0; j--){
            if(arr[j] == 2){
                end = j;
                break;
            }
        }
        
        
        if(start == 0 && end == 0){
            answer.add(-1);
        }
        
        else if(start == end){
            for(int i = start; i<= end; i++){
                answer.add(arr[i]);
            }
        }
        else{
            for(int i = start; i<= end; i++){
                answer.add(arr[i]);
            }
        }
        
        return answer;
    }
}