import java.util.*;
class Node{
    int num;
    long count;
    public Node(int num, long count){
        this.num = num;
        this.count = count;
    }
}

class Solution {
    ArrayList<Integer> pro[]; 
    ArrayList<Node> arr = new ArrayList<>(); 
    boolean visited[];
    long answer = 0;
    public long solution(int[] a, int[][] edges) {
        pro = new ArrayList[a.length];
        visited = new boolean[a.length];
        for(int i =0; i< a.length; ++i){
            pro[i] = new ArrayList<>();
        }
        for(int i = 0; i<a.length; ++i){
            arr.add(new Node(i,a[i]));
        }
        for(int i = 0; i< edges.length; ++i){
            int u = edges[i][0];
            int v = edges[i][1];
            pro[u].add(v);
            pro[v].add(u);
        }
        if(!DFS(0,0)){
            return -1;
        }
        else return answer;
    }
    
    public boolean DFS(int now, int parent){
        visited[now] = true;
        for(int i = 0; i< pro[now].size(); ++i){
            int next = pro[now].get(i);
            if(visited[next]) continue;
            DFS(next,now);
        }
        if(now == parent){ 
            if(arr.get(now).count != 0) return false;
        }
        arr.get(parent).count += arr.get(now).count;
        answer += Math.abs(arr.get(now).count);
        arr.get(now).count = 0;
        return true;
    }
}