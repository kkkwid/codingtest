class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i<s.length(); i++ ){
            char ch = s.charAt(i);
            if(ch != ' '){
                if(ch >= 'a' && ch <= 'z'){
                    char c = (char)(ch + n);
                    if(c >'z'){
                        c = (char)(c - 26);
                    }
                    answer += c;
                }
                else if( ch >= 'A' && ch <= 'Z' ){
                    char c= (char)(ch + n);
                    if( c > 'Z'){
                        c = (char) (c -26);
                    }
                    answer += c;
                }
            }
            else {
                answer += ch;
            }
        }
        return answer;
    }
}