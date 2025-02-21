class Solution {
    public String solution(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        boolean isEven = true;
        
        for(int i = 0; i<s.length(); i++){
            if(ch[i] == ' '){
                answer += " ";
                isEven = true;
            }
            else if(isEven){
                answer += Character.toUpperCase(ch[i]);
                isEven = false;
            }
            else{
                answer += Character.toLowerCase(ch[i]);
                isEven = true;
            }
        }
        return answer;
    }
}