class Solution {
    public int solution(int[] money) {
        int[] DP1 = new int[money.length]; 
        DP1[0] = money[0];
        DP1[1] = money[0];
        
        int[] DP2 = new int[money.length]; 
        DP2[1] = money[1];
        
        for(int i=2; i<money.length; i++){
            DP1[i] = Math.max(DP1[i-1], DP1[i-2]+money[i]);
            DP2[i] = Math.max(DP2[i-1], DP2[i-2]+money[i]);
        }
        
        return Math.max(DP1[money.length-2],DP2[money.length-1]);
    }
}