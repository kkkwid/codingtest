import java.util.HashMap;

class Solution {
    static Node root = new Node();

    static int solution(String[] words) {
        int answer = 0;

        for(String word: words){
            insert(word);
        }

        return search(root, 0);
    }

    static void insert(String word){
        Node curNode = root;
        for(int i = 0; i < word.length(); i++){
            Node newRoot = curNode.put(word.charAt(i));
            curNode = newRoot;
        }
        curNode.put('*');
    }

    static int search(Node root, int cnt){
        if(root.childCount == 1){
            return cnt;
        }
        int count = 0;
        for(char key: root.childNodes.keySet()){
            if(key == '*'){
                count += cnt;
            }
            else{
                count += search(root.childNodes.get(key), cnt+1);
            }
        }
        return count;
    }

    static class Node{
        private HashMap<Character, Node> childNodes = new HashMap<>();
        private int childCount = 0;

        Node put(char c){
            childCount++;
            if(!childNodes.containsKey(c)) {
                childNodes.put(c, new Node());
            }
            return childNodes.get(c);
        }
    }
}