import java.util.*;
class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        
        String sub = sb.substring(s,e+1);
        
        String reversed = new StringBuilder(sub).reverse().toString();
        sb.replace(s,e+1,reversed);
        return sb.toString();
    }
}