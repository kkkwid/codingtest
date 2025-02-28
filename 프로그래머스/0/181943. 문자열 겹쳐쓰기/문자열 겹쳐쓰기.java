class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int sl = my_string.length();
        int ol = overwrite_string.length();
        
        answer = my_string.substring(0,s) + overwrite_string + my_string.substring(ol+s,sl);
        
        
        return answer;
    }
}