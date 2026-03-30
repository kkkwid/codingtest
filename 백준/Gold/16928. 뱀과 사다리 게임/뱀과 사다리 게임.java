import java.io.*;
import java.util.*;

public class Main {

	static class boardPoint{
		int cur, count;
		public int getCur() {
			return cur;
		}

		public int getCount() {
			return count;
		}

		public boardPoint(int cur, int count) {
			this.cur = cur;
			this.count = count;
		}

	}
	static int N,M;
	static int[] ladder = new int[101];	
	static int[] snake = new int[101];
	static boolean[] visited = new boolean[101];
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
     
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		ladder[x] = y;
    	}
       
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		snake[u] = v;
    	}
    	int result = game();	
    	bw.write(result + "\n");	
    	bw.flush();	
    	bw.close();
    	br.close();
    }

    static int game() {
    	Queue<boardPoint> queue = new LinkedList<boardPoint>();
    	queue.add(new boardPoint(1, 0));
    	visited[1] = true;	
    	while(!queue.isEmpty()) {
    		boardPoint temp = queue.poll();
    		int cur = temp.getCur();
    		int count = temp.getCount();
    		if(cur==100)	
    			return count;	
    		for(int i=1;i<=6;i++) {	
    			int next = cur + i;
    			if(next<=100 && !visited[next]) {	
    				visited[next] = true;
    				if(ladder[next]!=0) {		
    					visited[ladder[next]] = true;
    					queue.add(new boardPoint(ladder[next], count+1));
    				}else if(snake[next]!=0) {	
    					visited[snake[next]] = true;
    					queue.add(new boardPoint(snake[next], count+1));
    				}else {		
    					queue.add(new boardPoint(next, count+1));
    				}
    			}
    		}
    	}
    	return 0;
    }
}