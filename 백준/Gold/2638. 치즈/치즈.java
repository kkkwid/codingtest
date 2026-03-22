import java.io.*;
import java.util.*;

public class Main {
    static class position{
		int x, y;
		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};	
	static int cheesesCount = 0;	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
        for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)	
					cheesesCount++;
			}
		}
		int answer = 0;
        while(cheesesCount != 0) {
			answer++;	
			setCheese(N, M);	
		}
		bw.write(answer + "");	
		bw.flush();		
		bw.close();
		br.close();		
	}

    static void setCheese(int N, int M) {
		Queue<position> q = new LinkedList<>();
		int[][] visited = new int[N][M];	
		ArrayList<position> removeCheeses = new ArrayList<>();	
		visited[0][0]++;	
		q.add(new position(0,  0));	
        while(!q.isEmpty()) {
			position cur = q.poll();
            for(int i=0;i<4;i++) {
				int tempX = cur.x + dx[i];
				int tempY = cur.y + dy[i];
                if(inSpace(tempX, tempY, N, M)) {
                    if(map[tempY][tempX] == 0 && visited[tempY][tempX] == 0) {
						visited[tempY][tempX] = 1;	
						q.add(new position(tempX, tempY));
					}
                    else if(map[tempY][tempX] == 1 && visited[tempY][tempX] < 2) {
						visited[tempY][tempX]++;	
						if(visited[tempY][tempX] == 2)	
							removeCheeses.add(new position(tempX, tempY));
					}
				}
			}
		}
        for(int i=0;i<removeCheeses.size();i++)
			map[removeCheeses.get(i).y][removeCheeses.get(i).x] = 0;
		cheesesCount -= removeCheeses.size();	
	}
    static boolean inSpace(int x, int y, int N, int M) {
		if(x >= 0 && y>=0 && y<N && x < M)
			return true;
		return false;
	}

}