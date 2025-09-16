import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsLength = friends.length;
        
        HashMap<String, Integer> friendsMap = new HashMap<>();
        for(int i = 0; i < friendsLength; i++){
            friendsMap.put(friends[i], i);
        }
        int[] giftDegree = new int[friendsLength];
        int[][] giftGraph = new int[friendsLength][friendsLength];
        
        for(String gift : gifts){
            String[] giftName = gift.split(" "); 
            giftDegree[friendsMap.get(giftName[0])]++;
            giftDegree[friendsMap.get(giftName[1])]--; 
            giftGraph[friendsMap.get(giftName[0])][friendsMap.get(giftName[1])]++;
        }
        
        int answer = 0;
        
        for(int i = 0; i < friendsLength; i++){
            int count = 0;
            for(int j = 0; j < friendsLength; j++){
                if(i == j){
                    continue;
                }
                
                if(giftGraph[i][j] > giftGraph[j][i] || 
                  (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])){
                    count++;
                }
                
                if(answer < count){
                    answer = count;
                }
            }
        }
        
        return answer;
    }
}