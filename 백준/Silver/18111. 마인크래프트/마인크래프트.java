import java.io.*;
import java.util.*;

public class Main {
    static int totalTime = Integer.MAX_VALUE;
    static int height = 0;

    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for (int targetHeight = min; targetHeight <= max; targetHeight++) {
            landLeveling(targetHeight, b);
        }

        System.out.println(totalTime + " " + height);


    }

    private static void landLeveling(int targetHeight, int inventory) {
        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == targetHeight) continue;

                if (map[i][j] > targetHeight) {
                    currentTime += (map[i][j] - targetHeight) * 2;
                    inventory += map[i][j] - targetHeight;
                    continue;
                }

                if (map[i][j] < targetHeight) {
                    int secondWork = targetHeight - map[i][j];

                    currentTime += secondWork;
                    inventory -= secondWork;
                }
            }
        }

        if (inventory < 0) return;

        if (currentTime < totalTime || (currentTime == totalTime && targetHeight > height)) {
            totalTime = currentTime;
            height = targetHeight;
        }


    }
}