import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[][] server = new int[2][24];
        Arrays.fill(server[0], 0); 
        Arrays.fill(server[1], 0); 

        for (int i = 0; i < 24; i++) {
            int nowNeed = players[i] / m;
            int nowCom = server[0][i];    

            if (nowNeed > nowCom) { 
                int upgrade = nowNeed - nowCom;
                server[1][i] = (i == 0) ? nowNeed : server[1][i - 1] + upgrade;

                for (int j = i; j < i + k; j++) {
                    if (j <= 23) {
                        server[0][j] += upgrade;
                    } else {
                        break;
                    }
                }
            } else { 
                server[1][i] = (i == 0) ? nowNeed : server[1][i - 1];
            }
        }

        return server[1][23];
    }
}