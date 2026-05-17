import java.util.*;
 
class Solution {
    public int solution(String[] strs, String t) {
        
        char[][] strsArr = new char[strs.length][];
        for(int i = 0; i < strs.length; i++) {
            strsArr[i] = strs[i].toCharArray();
        }
        
        char[] tArr = t.toCharArray();
        
        int[] count = new int[tArr.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        int answer = -1;
        
        int[] now; boolean flag;
        while(!q.isEmpty()) {
            now = q.poll();
            
            for(int i = 0; i < strsArr.length; i++) {
                flag = true;
                for(int j = 0; j < strsArr[i].length; j++) {
                    if(now[0] + j >= tArr.length || tArr[now[0] + j] != strsArr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    if(now[0] + strsArr[i].length == tArr.length) {
                        answer = answer == -1 ? now[1] + 1 : Math.min(answer, now[1] + 1);
                    }
                    else if(count[now[0] + strsArr[i].length] > now[1] + 1){
                        count[now[0] + strsArr[i].length] = now[1] + 1;
                        q.add(new int[] {now[0] + strsArr[i].length, now[1] + 1});
                    }
                }
            }
        }
 
        return answer;
    }
}