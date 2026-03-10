import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[][] star = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star[i][j] = "*";
            }
        }

        recursive(N, star, 0, 0);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int N, String[][] star, int r, int c) {
        if (N == 1) return;

        int newN = N / 3;

        for (int i = r + newN; i < r + 2 * newN; i++) {
            for (int j = c + newN; j < c + 2 * newN; j++) {
                star[i][j] = " ";
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                recursive(newN, star, r + row * newN, c + col * newN);
            }
        }
    }
}