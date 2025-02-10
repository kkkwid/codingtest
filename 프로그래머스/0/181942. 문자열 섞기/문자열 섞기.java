class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        for(int i= 0; i<str1.length(); i++){
            answer += ""+str1.charAt(i)+str2.charAt(i);
            // 문자와 문자 합치는거에서는 앞에 "" 붙히면 가능
        }
        return answer;
    }
}