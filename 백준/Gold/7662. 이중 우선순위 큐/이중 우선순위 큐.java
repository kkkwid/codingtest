import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int T;
    public static int K;
    public static TreeMap<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){

            K = Integer.parseInt(br.readLine());
            map.clear();
            for(int i = 0 ; i < K ; i++){
                String[] stmt = br.readLine().split(" ");
                if(stmt[0].equals("I")){
                    int num = Integer.parseInt(stmt[1]);
                     if(map.containsKey(num)){
                         map.put(num, map.get(num) + 1);
                     }else{
                         map.put(num , 1);
                     }
                }else {
                    if(map.size() == 0){
                        continue;
                    }
                    if(stmt[1].equals("1")){
                        Map.Entry<Integer,Integer> entry = map.firstEntry();
                        int count = entry.getValue();
                        int key = entry.getKey();
                        if(count == 1){
                            map.remove(key);
                        }else{
                            map.put(key, count - 1);

                        }
                    }else{
                        Map.Entry<Integer,Integer> entry = map.lastEntry();
                        int count = entry.getValue();
                        int key = entry.getKey();
                        if(count == 1){
                            map.remove(key);
                        }else{
                            map.put(key, count - 1);
                        }
                    }
                }
            }
            if(map.size() == 0){
                System.out.println("EMPTY");
            }else{
                System.out.print(map.firstEntry().getKey()+ " " + map.lastEntry().getKey() + "\n");
            }
        }
    }
}