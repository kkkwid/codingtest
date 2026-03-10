import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();
            input = input.substring(1, input.length() - 1); // 대괄호 제거
            if (!input.isEmpty()) {
                String[] nums = input.split(",");
                for (String s : nums) {
                    dq.add(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (dq.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if (isReversed) dq.pollLast();
                    else dq.pollFirst();
                }
            }

            if (!isError) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                while (!dq.isEmpty()) {
                    sb.append(isReversed ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) sb.append(",");
                }

                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
