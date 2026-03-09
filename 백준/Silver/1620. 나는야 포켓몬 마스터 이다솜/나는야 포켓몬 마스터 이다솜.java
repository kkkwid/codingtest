import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> s2i = new HashMap<>();
        Map<Integer, String> i2s = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            s2i.put(str, i+1);
            i2s.put(i+1, str);
        }
        for(int i=0; i<M; i++){
            String str = br.readLine();
            int test = s2i.getOrDefault(str, -1);
            if(test < 0) {
                sb.append(i2s.get(Integer.parseInt(str)));
            }
            else{
                sb.append(test);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}