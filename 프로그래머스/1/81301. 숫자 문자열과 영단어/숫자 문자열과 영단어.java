import java.util.Arrays;
class Solution {
    public int solution(String s) {
        String answer = "";
        char[] ch = new char[s.length()];
        for(int i = 0; i< ch.length; i++){
            ch[i] = s.charAt(i);
        }
        String str = "";
        for(int i = 0; i< ch.length; i++){
            str += ch[i];
            if(str.equals("zero") || str.equals("0")){
                answer += "0";
                str = "";
            }
            else if(str.equals("one") || str.equals("1")){
                answer += "1";
                str = "";
            }
            else if(str.equals("two") || str.equals("2")){
                answer += "2";
                str = "";
            }
            else if(str.equals("three") || str.equals("3")){
                answer += "3";
                str = "";
            }
            else if(str.equals("four") || str.equals("4")){
                answer += "4";
                str = "";
            }
            else if(str.equals("five") || str.equals("5")){
                answer += "5";
                str = "";
            }
            else if(str.equals("six") || str.equals("6")){
                answer += "6";
                str = "";
            }
            else if(str.equals("seven") || str.equals("7")){
                answer += "7";
                str = "";
            }
            else if(str.equals("eight") || str.equals("8")){
                answer += "8";
                str = "";
            }
            else if(str.equals("nine") || str.equals("9")){
                answer += "9";
                str = "";
            }
        }
        int result = Integer.parseInt(answer);
        
        return result;
    }
    
}