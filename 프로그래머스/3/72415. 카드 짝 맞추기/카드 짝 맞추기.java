import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean [] memo = new boolean [7]; 
    static boolean [] visited = new boolean [7];
    static int [][] record = new int [7][4];
    static int [] sequence;
    static int [][] boards;
    static int size;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static final int MAX = 16;
    public int solution(int[][] board, int r, int c) {
        boards = board; 
        size = board.length;
        init();
        backTracking(0, r, c, 0);
        return answer;
    }
    public static int game(int sx, int sy, int ex, int ey, int cur_x, int cur_y){
        int num = boards[sx][sy];
        int sum = 0;
        int [][] map = new int [size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = MAX;
            }
        }
        map[cur_x][cur_y] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int [] {cur_x, cur_y});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for(int i = 0; i < 4; i++){  
                int x = cur[0] + arx[i];
                int y = cur[1] + ary[i];
                if(!validation(x, y)) continue;
                if(map[x][y] > map[cur[0]][cur[1]] + 1){
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    q.add(new int [] {x, y});
                }
                
                if(boards[x][y] != 0 ) continue; 
                
                boolean flag = false; 
                while(true){
                    x += arx[i];
                    y += ary[i];
                    if(!validation(x, y)) break;
                    if(boards[x][y] != 0){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    x -= arx[i];
                    y -= ary[i];
                }
                if(map[x][y] > map[cur[0]][cur[1]] + 1){
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    q.add(new int []{x, y});
                }
            }
        }
        sum += map[sx][sy];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = MAX;
            }
        }
        map[sx][sy] = 0;
        q.add(new int [] {sx, sy});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for(int i = 0; i < 4; i++){  
                int x = cur[0] + arx[i];
                int y = cur[1] + ary[i];
                if(!validation(x, y)) continue;
                if(map[x][y] > map[cur[0]][cur[1]] + 1){
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    q.add(new int [] {x, y});
                }
                
                if(boards[x][y] != 0 ) continue; 
                
                boolean flag = false;
                while(true){
                    x += arx[i];
                    y += ary[i];
                    if(!validation(x, y)) break;
                    if(boards[x][y] != 0){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    x -= arx[i];
                    y -= ary[i];
                }
                if(map[x][y] > map[cur[0]][cur[1]] + 1){
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    q.add(new int []{x, y});
                }
            }
        }
        
        boards[sx][sy] = 0;
        boards[ex][ey] = 0; 
        sum += map[ex][ey];
        sum += 2; 
        return sum;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < size && ny < size) return true;
        return false;
    }    

    public static void backTracking(int depth, int x, int y, int count){
        if(depth == sequence.length){
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 1; i <= 6; i++){
            if(!memo[i] || visited[i]) continue;
            visited[i] = true;
            sequence[depth] = i;
            
            int use1 = game(record[i][0], record[i][1], record[i][2], record[i][3], x, y);
            
            backTracking(depth + 1, record[i][2], record[i][3], count + use1);
            
            boards[record[i][0]][record[i][1]] = i;
            boards[record[i][2]][record[i][3]] = i;
            
            int use2 = game(record[i][2], record[i][3], record[i][0], record[i][1], x, y);
            
            backTracking(depth + 1, record[i][0], record[i][1], count + use2);
            
            boards[record[i][0]][record[i][1]] = i;
            boards[record[i][2]][record[i][3]] = i;
            
            visited[i] = false;
        }
    }

    public static void init(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int num = boards[i][j];
                if(num == 0) continue;
                if(!memo[num]){
                    memo[num] = true;
                    record[num][0] = i;
                    record[num][1] = j;
                }
                else{
                    record[num][2] = i;
                    record[num][3] = j;
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= 6; i++){
            if(memo[i]) count++;
        }
        sequence = new int [count];
    }
}