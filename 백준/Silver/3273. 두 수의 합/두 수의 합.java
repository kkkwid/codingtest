import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 원소 개수
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = Integer.parseInt(br.readLine()); // 목표 합

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            if (set.contains(sum - num)) {
                count++;
            }
            set.add(num);
        }

        System.out.println(count);
    }
}
