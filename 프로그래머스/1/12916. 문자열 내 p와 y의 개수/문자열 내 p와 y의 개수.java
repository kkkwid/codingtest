class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcount = 0;
        int ycount = 0;
        String str = "";
        for(int i = 0; i<s.length(); i++){
            char b = s.charAt(i);
            if(Character.isUpperCase(b)){
                str += Character.toLowerCase(b);
            }
            else{
                str += b;
            }
        }
        
        System.out.println(str);
        
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == 'p'){
                pcount++;
            }
            else if(str.charAt(i) == 'y'){
                ycount++;
            }
        }
        
        return pcount == ycount;
    }
}