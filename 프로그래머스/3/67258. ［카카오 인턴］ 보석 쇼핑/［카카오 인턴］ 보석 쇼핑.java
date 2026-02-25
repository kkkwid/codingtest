import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;
        HashSet<String> set = new HashSet<String>();
        for(String s : gems){
            set.add(s);
        }
        int cnt = set.size();
        System.out.println("cnt: "+cnt);
        
        
        int left=0;
        int right=0;
        int startIndex=0;
        int endIndex=0;
        int diff=Integer.MAX_VALUE;
         
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        while(true){
           if(set.size()==map.size()){ 
                map.put(gems[left],map.get(gems[left])-1);
                if(map.get(gems[left])==0)
                    map.remove(gems[left]); 
                
                left ++;
                
            }else if(right==n){ 
               break;
               
           }else{
                map.put(gems[right],map.getOrDefault(gems[right],0)+1);
                right++; 
            }
            
            if(set.size()==map.size()){
                    if((right-1)-left<diff){
                        startIndex=left;
                        endIndex=right-1;
                        diff=(right-1)-left;
                    }
                }

        }
        answer[0]=startIndex+1;
        answer[1]=endIndex+1;
        return answer;
    }
}