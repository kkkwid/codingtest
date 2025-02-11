class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        String[] con = control.split("");
        
        for(int i = 0; i < con.length; i++){
            if(con[i].equals("w")){
                n+=1;
            }
            else if (con[i].equals("s")){
                n-=1;
            }
            else if(con[i].equals("d")){
                n+=10;
            }
            else {
                n-=10;
            }
        }
        return n;
    }
}