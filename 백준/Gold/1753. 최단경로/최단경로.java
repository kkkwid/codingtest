import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val, weight;

        public Node(int row, int weight) {
            this.val = row;
            this.weight = weight;
        }
    }
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vCnt = Integer.parseInt(st.nextToken());
        int eCnt = Integer.parseInt(st.nextToken());

        int startV = Integer.parseInt(br.readLine());
        visited = new int[vCnt + 1];
        for (int i = 1; i <= vCnt ; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= vCnt; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < eCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(end, weight));
        }
        BFS(startV, nodes);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vCnt; i++) {
            if (visited[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(visited[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int startV, ArrayList<ArrayList<Node>> nodes) {
        visited[startV] = 0;
        PriorityQueue<Node> priQueue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.weight)
        );
        priQueue.add(new Node(startV, 0));
        while (!priQueue.isEmpty()) {
            Node nowNode = priQueue.poll();
            for (Node nextNode : nodes.get(nowNode.val)) {
                int nextWeight = nowNode.weight + nextNode.weight;
                if (visited[nextNode.val] > nextWeight) {
                    visited[nextNode.val] = nextWeight;
                    priQueue.add(new Node(nextNode.val, nextWeight));
                }
            }
        }
    }
}