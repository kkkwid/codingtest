import java.util.*;

class Node {
    int x;
    int y;
    int type;
    
    Node (int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

class Solution {
    
    boolean[][] col;
    boolean[][] row;
    int N;
    List<Node> list = new ArrayList<>();
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        col = new boolean[n+1][n+1];
        row = new boolean[n+1][n+1];
        N = n;
        
        for (int i=0; i<build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            if (a == 0 && b == 1) {
                if(canCol(x, y)) col[y][x] = true;
            }
            else if (a == 1 && b == 1) {
                if(canRow(x, y)) row[y][x] = true;
            }
            else if (a == 0 && b == 0) {
                col[y][x] = false;
                if (!canDelete()) col[y][x] = true;
            }
            else {
                row[y][x] = false;
                if (!canDelete()) row[y][x] = true;
            }
        }
        
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (col[i][j]) list.add(new Node(j,i,0));
                if (row[i][j]) list.add(new Node(j,i,1));
            }
        }
        
        list.sort((n1,n2) -> {
            if (n1.x != n2.x) return n1.x - n2.x;
            return n1.y - n2.y;
        });
        
        answer = new int[list.size()][3];
        
        for (int i=0; i<list.size(); i++) {
            answer[i][0] = list.get(i).x;
            answer[i][1] = list.get(i).y;
            answer[i][2] = list.get(i).type;
        }
        
        return answer;
    }
    
    boolean canCol(int x, int y) {
        if (y == 0) return true;
        if (y-1 >= 0 && col[y-1][x]) return true;
        if (x-1 >= 0 && row[y][x-1]) return true;
        if (row[y][x]) return true;
        return false;
    }
    
    boolean canRow(int x, int y) {
        if (col[y-1][x]) return true;
        if (x+1 <= N && col[y-1][x+1]) return true;
        if (x-1 >= 0 && x+1 <= N && row[y][x+1] && row[y][x-1]) return true;
        return false;
    }
    
    boolean canDelete() {
        for (int i=0; i<=N; i++) {
            for (int j=0; j<=N; j++) {
                if (col[i][j] && !canCol(j,i)) return false;
                if (row[i][j] && !canRow(j,i)) return false;
            }
        }
        
        return true;
    }
}