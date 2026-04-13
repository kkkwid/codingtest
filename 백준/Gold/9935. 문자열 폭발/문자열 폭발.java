import java.io.*;
import java.util.*;


public class Main {

    public static int N;
    public static Stack<Item> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();
    public static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int cursor = 0;
        for(int i = 0 ; i < str.length() ; i++){
            set.add(i);
            if(bomb.charAt(cursor) == str.charAt(i)){ 
                cursor++;
                stack.push(new Item(i, cursor));

            }else if(cursor > 0 && bomb.charAt(0) == str.charAt(i)){
                cursor = 1;
                stack.push(new Item(i,cursor));
            }else {

                cursor = 0;
                stack.push(new Item(i,cursor));
            }

            if(cursor == bomb.length()){
                for(int j = 0 ; j < cursor ; j++){
                    Item item = stack.pop();
                    set.remove(item.index);
                }
                cursor = stack.isEmpty() ? 0 : stack.peek().cursor;
            }

        }
        if(set.isEmpty()){
            System.out.println("FRULA");
        }else {
            Iterator<Integer> it = set.iterator();

            while (it.hasNext()) {
                sb.append(str.charAt(it.next()));
            }
            System.out.println(sb);
        }
    }


}
class Item{
    int index;
    int cursor;

    public Item(int index , int cursor){this.index = index ; this.cursor = cursor;}

    @Override
    public String toString(){
        return index + "";
    }
}