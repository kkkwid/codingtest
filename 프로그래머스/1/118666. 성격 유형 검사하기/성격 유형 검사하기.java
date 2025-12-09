import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[] scores = new int[]{0,3,2,1,0,1,2,3};
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<choices.length;i++){
            String str= survey[i];
            int score = scores[choices[i]];
            char c =survey[i].charAt(0);
            char c2=survey[i].charAt(1);
            if(choices[i]<4){     
                 if(!map.containsKey(c2)){
                    map.put(c2,0);
                } 
                
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+score);
                    continue;
                }            
                map.put(c,score);
            }
            else if(choices[i]>4){
                if(!map.containsKey(c)){
                    map.put(c,0);
                }   
                
                if(map.containsKey(c2)){
                    map.put(c2,map.get(c2)+score);
                    continue;
                }
                map.put(c2,score);
            }
            else{
                
                if(map.containsKey(c)){
                    continue;
                }
                map.put(c,0);
                if(map.containsKey(c2)){
                    continue;
                }
                map.put(c2,0);
                
            }
        }
       
       if(map.get('R')==null||map.get('R')>=map.get('T')){
           answer+="R";
       }
        else{
            answer+="T";
        }
        
       if(map.get('C')==null||map.get('C')>=map.get('F')){
           answer+="C";
       }
        else{
            answer+="F";
        } 
        
       if(map.get('J')==null||map.get('J')>=map.get('M')){
           answer+="J";
       }
        else{
            answer+="M";
        }
         
       if(map.get('A')==null||map.get('A')>=map.get('N')){
           answer+="A";
       }
        else{
            answer+="N";
        }
        
        return answer;
    }
}