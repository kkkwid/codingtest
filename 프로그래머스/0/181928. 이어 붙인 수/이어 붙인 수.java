class Solution {
    public int solution(int[] num_list) {
        String jjak = "";
        String hole = "";
        for(int i = 0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                hole += ""+String.valueOf(num_list[i]);
            }
            else{
                jjak += ""+String.valueOf(num_list[i]);
            }
        }
        int answer = Integer.parseInt(hole) + Integer.parseInt(jjak);
        return answer;
    }
}