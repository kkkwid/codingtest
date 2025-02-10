class Solution {
    public int solution(int[] num_list) {
        int listsum = 0;
        int listdiv = 1;
        
        for(int i = 0; i< num_list.length; i++){
            listsum += num_list[i];
            listdiv *= num_list[i];
        }
        int answer = listdiv < Math.pow(listsum,2) ? 1 : 0;
    
        return answer;
    }
}