import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
    static class Node{
        char currentChar;
        char leftChild; 
        char rightChild;

        public Node(char currentChar) {
            this.currentChar = currentChar;
            this.leftChild = '0';
            this.rightChild = '0';
        }

        public void setLeftChild(char leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(char rightChild) {
            this.rightChild = rightChild;
        }

    }

    static int n;
    static Node[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); 
        graph = new Node[n]; 
        while(n-->0){ 
            StringTokenizer st = new StringTokenizer(br.readLine());
            char currentChar = st.nextToken().charAt(0); 
            int index = currentChar-65; 
            graph[index] = new Node(currentChar); 
            char leftChild = st.nextToken().charAt(0);
            if(leftChild != '.') graph[index].setLeftChild(leftChild); 
            char rightChild = st.nextToken().charAt(0);
            if(rightChild != '.') graph[index].setRightChild(rightChild); 
        }
        preorderSearch(graph[0]); 
        sb.append("\n");
        inorderSearch(graph[0]);
        sb.append("\n");
        postorderSearch(graph[0]); 
        sb.append("\n");
        System.out.println(sb);

    }

    static void preorderSearch(Node node){
        sb.append(node.currentChar); 
        if(node.leftChild != '0') preorderSearch(graph[node.leftChild-65]); 
        if(node.rightChild != '0') preorderSearch(graph[node.rightChild-65]);
    }
    static void inorderSearch(Node node){
        if(node.leftChild != '0') inorderSearch(graph[node.leftChild-65]);
        sb.append(node.currentChar);
        if(node.rightChild != '0') inorderSearch(graph[node.rightChild-65]);
    }
    static void postorderSearch(Node node){
        if(node.leftChild != '0') postorderSearch(graph[node.leftChild-65]);
        if(node.rightChild != '0') postorderSearch(graph[node.rightChild-65]);
        sb.append(node.currentChar);
    }

}