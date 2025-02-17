import java.util.*;
class Solution {
    public int solution(String my_string, String is_suffix) {
        for(int i = 0; i < my_string.length(); i++) {
            String str = my_string.substring(i); 
            if(str.equals(is_suffix)){
                return 1;
            }
        }
        return 0;
    }
}