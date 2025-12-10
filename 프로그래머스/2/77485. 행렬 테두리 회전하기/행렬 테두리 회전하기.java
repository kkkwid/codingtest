import java.util.*;
class Solution {
    public int[][] map;
    public ArrayList<Integer> answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new ArrayList<Integer>();
        map = new int[rows+1][columns+1];
        int num = 1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = num;
                num++;
            }  
            
        }
        for(int i = 0; i < queries.length; i++){
            answer.add(rotate(queries[i]));   
        }
    
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    public int rotate(int[] query){
        int sX = query[0];
        int sY = query[1];
        int eX = query[2];
        int eY = query[3];
        int prev = map[sX][sY];
        int min = prev;
        for(int i = sY+1; i <= eY; i++){
            int temp = map[sX][i];
            map[sX][i] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        for(int i = sX+1; i <= eX; i++){
            int temp = map[i][eY];
            map[i][eY] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        for(int i = eY-1; i >= sY; i--){
            int temp = map[eX][i];
            map[eX][i] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        for(int i = eX-1; i >= sX; i--){
            int temp = map[i][sY];
            map[i][sY] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
     
        return min;
    }
}