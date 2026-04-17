import java.util.PriorityQueue;
import java.util.Scanner;

class Shark {
    int x;
    int y;
    int move;

    public Shark(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
public class Main {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] board;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 0);
                    board[i][j] = 0;
                }
            }

        int size = 2;
        int eat = 0;
        int totalMove = 0; 

        while (true) {
            PriorityQueue<Shark> que = new PriorityQueue<>((s1, s2) -> {
                if (s1.move != s2.move) {
                    return s1.move - s2.move;
                } else {
                    if (s1.x != s2.x)
                        return s1.x - s2.x;
                    return s1.y - s2.y;
                }
            });

            boolean[][] visit = new boolean[N][N];

            que.add(new Shark(shark.x, shark.y, 0));
            visit[shark.x][shark.y] = true;

            boolean eatFood = false;

            while (!que.isEmpty()) {
                shark = que.poll();

                if (board[shark.x][shark.y] != 0 && board[shark.x][shark.y] < size) { 
                    board[shark.x][shark.y] = 0; 
                    eat++;
                    totalMove += shark.move;
                    eatFood = true; 
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = shark.x + dx[k];
                    int ny = shark.y + dy[k];

                    if (outOfBoard(nx, ny) || visit[nx][ny] || board[nx][ny] > size) {
                        continue;
                    }

                    que.add(new Shark(nx, ny, shark.move + 1));
                    visit[nx][ny] = true;
                }
            }

            if (!eatFood)
                break;

            if (size == eat) { 
                size++;
                eat = 0;
            }
        }


        System.out.println(totalMove);

    }
    static boolean outOfBoard ( int x, int y){
        return x < 0 || y < 0 || x >= N || y >= N;
    }


}