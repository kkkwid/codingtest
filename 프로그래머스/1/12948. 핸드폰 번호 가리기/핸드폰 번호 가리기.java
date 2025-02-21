class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int count = phone_number.length();
        for(int i = 0; i<phone_number.length(); i++){
            if(count < 5){
                answer += phone_number.charAt(i);
            }
            else answer += "*";
            count--;
            
        }
        return answer;
    }
}