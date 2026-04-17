import java.util.*;
import java.io.*;

public class Main{
	static int N,M,X;
	static final int INF=33333333;
	
	static List<Node>graph1[];
	static List<Node>graph2[];
	
	static int dist1[];
	static int dist2[];

	static class Node implements Comparable<Node>{
		int v,cost;
		Node(int v,int cost){
			this.v=v;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	private static int[] Dijkstra(int x,List<Node>graph[]) {
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		boolean visited[]=new boolean[N+1];
		int dist[]=new int[N+1];
		
		Arrays.fill(dist,INF);
		
		pq.offer(new Node(x,0));
		dist[x]=0;
		
		while(!pq.isEmpty()) {
			Node now=pq.poll();
			int nv=now.v;
			int nc=now.cost;
			
			if(visited[nv]) continue;
			visited[x]=true;
			
			for(int i=0;i<graph[nv].size();i++) {
				Node tmp=graph[nv].get(i);
				int tv=tmp.v;
				int tc=tmp.cost;
				
				if(dist[tv] > dist[nv]+tc) {
					dist[tv] = dist[nv]+tc;
					pq.offer(new Node(tv,dist[tv]));
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		X=Integer.parseInt(stk.nextToken());
		
		graph1=new ArrayList[N+1];
		graph2=new ArrayList[N+1];
		dist1=new int[N+1];
		dist2=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			graph1[i]=new ArrayList<>();
			graph2[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			int c=Integer.parseInt(stk.nextToken());
			
			graph1[s].add(new Node(e,c));
			graph2[e].add(new Node(s,c));
		}
		
		dist1=Dijkstra(X,graph1);
		dist2=Dijkstra(X,graph2);
		
		int result=0;
		
		for(int i=1;i<=N;i++) 
			result=Math.max(result, dist1[i]+dist2[i]);
		
		System.out.print(result);
	}
}