class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int[][] maxSize = new int[park.length][park[0].length];
        int canSize = 0;
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length; j++){
                
                if(park[i][j].equals("-1")){
                    if(i==0 || j==0){
                        maxSize[i][j] = 1;
                    } else {
                        maxSize[i][j] = Math.min(Math.min(maxSize[i][j-1], maxSize[i-1][j]), maxSize[i-1][j-1]) + 1;
                    }
                    
                    canSize = Math.max(canSize, maxSize[i][j]);
                }
            }
        }
        
        for(int i=0; i<mats.length; i++){
            if(mats[i] <= canSize){
                answer = Math.max(answer, mats[i]);
            }
        }
        
        return answer;
    }
}