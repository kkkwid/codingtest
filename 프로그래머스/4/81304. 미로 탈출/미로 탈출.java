import java.util.*;

class Solution {
   	static int INF = Integer.MAX_VALUE;
	static int[][] dist;
	static List<Node>[] list, rList;
	static Map<Integer, Integer> trapList;

	static class Node implements Comparable<Node>{
		int to;
		int weight;
		int status;

		public Node(int to, int weight, int status) {
			this.to = to;
			this.weight = weight;
			this.status = status;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
        public int solution(int n, int start, int end, int[][] roads, int[] traps) {
            list = new ArrayList[n+1];
            rList = new ArrayList[n+1];
            for(int i=1; i<n+1; i++) {
                list[i] = new ArrayList<>();
                rList[i] = new ArrayList<>();
            }
            trapList = new HashMap<>();
            for(int i=0; i<traps.length; i++) {
                trapList.put(traps[i], 1<<(i+1));
            }

            for(int i=0; i<roads.length; i++) {
                int from = roads[i][0];
                int to = roads[i][1];
                int w = roads[i][2];

                list[from].add(new Node(to,w,0));
                rList[to].add(new Node(from,w,0));
            }

            dist= new int[n+1][1<<trapList.size()+1];
            for(int i=0; i<n+1; i++) {
                Arrays.fill(dist[i], INF);
            }

            dijkstra(start, end);

            int answer = INF;
            for(int ca : dist[end]) {
                answer = Math.min(answer, ca);
            }
            return answer;
        }
	
	static void dijkstra(int start, int end) {
		Queue<Node> q = new PriorityQueue<>();
		dist[start][0] = 0;
		q.add(new Node(start,0,0));

		while(!q.isEmpty()) {
			Node node = q.poll();
			int to = node.to;
			int w = node.weight;
			int status = node.status;

			if(to == end) return;
			int f1 = 0; 
			if(trapList.containsKey(to)) {
				if((status & trapList.get(to)) != 0) {
					f1 = 1;
				}
			}

			int canForward = f1; 
			for(Node nxt : list[to]) {
				canForward = f1;
				int nStatus= status;
				if(trapList.containsKey(nxt.to)) {
					if((status & trapList.get(nxt.to)) != 0){
						canForward ^= 1;  
					}
					nStatus ^= trapList.get(nxt.to);
				}
				if(canForward == 0) {
					if(dist[nxt.to][status] > w + nxt.weight) {
						dist[nxt.to][status] = w + nxt.weight;
						q.add(new Node(nxt.to, dist[nxt.to][status], nStatus));
					}
				}
			}

			for(Node nxt : rList[to]) {
				canForward = f1;
				int nStatus= status;
				if(trapList.containsKey(nxt.to)) {
					if((status & trapList.get(nxt.to)) != 0){
						canForward ^= 1;  
					}
					nStatus ^= trapList.get(nxt.to);
				}
				if(canForward ==1) {
					if(dist[nxt.to][status] > w + nxt.weight) {
						dist[nxt.to][status] = w + nxt.weight;
						q.add(new Node(nxt.to, dist[nxt.to][status], nStatus));
					}
				}
			}
		}
	}
}