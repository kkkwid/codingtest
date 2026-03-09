import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int pSize = 2*N + 1, answer = 0, count = 0;
        char cur = ' ';
        for(int i=0;i<M;i++) {
            char c = str.charAt(i);
            if(cur != c) {
                if(count == 0) {
                    if(c =='I') {
                        count++;
                        cur = c;
                    }
                }else {		
                    cur = c;
                    count++;
                }
            }else {
                answer += cal(pSize, count, N);
                count = 0;
                if(c == 'I')
                    count++;
                cur = c;
            }
        }
        answer += cal(pSize, count, N);
        bw.write(answer + "");
        bw.flush();	
        bw.close();
        br.close();
    }
    static int cal(int size, int count, int N) {
        int result = 0;
        if(count >= size) {
            int temp = (count - 1)/2;
            result = temp - (N-1);
        }
        return result;
    }
}