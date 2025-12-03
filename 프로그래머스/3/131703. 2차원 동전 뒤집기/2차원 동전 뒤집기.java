import java.util.*;
class Solution {
    static int [][] t;
    static int [][] b;
    static int answer = Integer.MAX_VALUE;
    static int n,m;
    public int solution(int[][] beginning, int[][] target) {
        t = target;
        b = beginning;
        n = beginning.length; m = beginning[0].length;
        func(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void check(int cnt){
        int count = 0;
        for(int i = 0; i < m; i++){
            int same = 0;
            int notSame = 0;
            for(int j = 0; j < n; j++){
                if(b[j][i] == t[j][i]) same++;
                else notSame++;
            }
            if(same == n) continue; 
            if(notSame == n){
                count++;
                continue;
            }
            return; 
        }
        answer = Math.min(answer, cnt + count);
    }
    public static void func(int depth, int cnt){
        if(depth == n){
            check(cnt);
            return;
        }
        change(depth);
        func(depth + 1, cnt + 1);
        change(depth);
        func(depth + 1, cnt); 
    }
    public static void change(int row){
        for(int i = 0; i < m; i++){
            b[row][i] = (b[row][i] + 1) % 2;
        }
    }
}