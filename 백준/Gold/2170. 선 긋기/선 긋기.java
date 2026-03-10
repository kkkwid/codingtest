import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Line> allLine = new ArrayList<>();

        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            allLine.add(new Line(start, end));
        }

        allLine.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int start = allLine.get(0).start;
        int end = allLine.get(0).end;
        int ans = 0;
        for (Line now : allLine) {
            if (now.start < end) {
                end = Math.max(end, now.end);
            } else {
                ans += end - start;
                start = now.start;
                end = now.end;
            }
        }
        ans += end - start; 

        System.out.println(ans);
    }
}
