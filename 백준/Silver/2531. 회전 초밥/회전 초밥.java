import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[D + 1];
        int unique = 0;

        for (int i = 0; i < K; i++) {
            if (cnt[arr[i]] == 0) unique++;
            cnt[arr[i]]++;
        }

        int result = unique + (cnt[C] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int left = arr[i - 1];
            cnt[left]--;
            if (cnt[left] == 0) unique--;

            int enter = arr[(i + K - 1) % N];
            if (cnt[enter] == 0) unique++;
            cnt[enter]++;

            int now = unique + (cnt[C] == 0 ? 1 : 0);
            if (now > result) result = now;
        }

        System.out.println(result);
    }
}
