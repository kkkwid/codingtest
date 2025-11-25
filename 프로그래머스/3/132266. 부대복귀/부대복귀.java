import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] road:roads){
            
            int a = road[0];
            int b= road[1];
                 
            List<Integer> a_list=map.getOrDefault(a,new ArrayList<>());
            a_list.add(b);
            map.put(a,a_list);
            
            List<Integer> b_list=map.getOrDefault(b,new ArrayList<>());
            b_list.add(a);
            map.put(b,b_list);
        }
        
        boolean[] visited= new boolean[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        Queue<Integer> que = new LinkedList<>();
        visited[destination]=true;
        que.add(destination);
        
        dp[destination]=0;
        
        while(!que.isEmpty()){
            int p=que.poll();
           
            List<Integer> p_list= map.get(p);
            
            for(int temp:p_list){
                if(!visited[temp]){
                    
                     visited[temp]=true;
                     dp[temp]=dp[p]+1;           
                     que.add(temp);
                }
               
            }
        }
      
        List<Integer> result = new ArrayList<>();
        for(int s:sources){
            if(dp[s]==Integer.MAX_VALUE){
                dp[s]=-1;
            }
            result.add(dp[s]);
        }
        
        answer=result.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}