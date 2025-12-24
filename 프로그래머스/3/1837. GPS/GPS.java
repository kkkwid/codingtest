import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int dp[][] = new int[k][n];
        List<Set<Integer>> edgeList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            edgeList.add(new HashSet<>());
            edgeList.get(i).add(i);
        }
        
        for(int[] edge : edge_list){
            edgeList.get(edge[1]-1).add(edge[0]-1);
            edgeList.get(edge[0]-1).add(edge[1]-1);
        }
        
        dp[0][gps_log[0]-1] = 1;
        
        for(int i = 0; i < k-1; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == 0){
                    continue;
                }
                
                for(int v : edgeList.get(j)){
                    int cost = dp[i][j];
                    if(gps_log[i+1]-1 != v){
                        cost++;
                    }
                    
                    dp[i+1][v] = dp[i+1][v] == 0 ? cost : Math.min(dp[i+1][v], cost);
                }
            }
        }
        
        int answer = dp[k-1][gps_log[k-1]-1] - 1;
        return answer;
    }
}