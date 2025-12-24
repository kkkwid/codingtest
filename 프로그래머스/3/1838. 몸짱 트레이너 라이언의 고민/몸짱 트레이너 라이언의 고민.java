import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    
    static int[][] board;
    static int[][] visited;
    static int num;
    static int answer;

    public static int solution(int n, int m, int[][] timetable) {

        answer = 0;

        board = new int[n][n];
        visited = new int[n][n];
        num = people(timetable);

        if(num <= 1)
        {
            return answer;
        }

        answer = calc(n);
        return answer;
    }

    // 거리를 계산하는 함수
    public static int calc(int n)
    {


        // 최대 거리는 2 * n - 2 이다.
        for(int dis = 2 * n - 2; dis > 0; dis--)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    ArrayList<dot> arr = new ArrayList<>();
                    arr.add(new dot(i,j));

                    for(int y = i; y < n; y++)
                    {
                        for(int x = 0; x < n; x++)
                        {
                            if(y == i && x <= j) continue;

                            boolean canPush = true;
                            for (dot d : arr)
                            {
                                int distance = Math.abs(d.y - y) + Math.abs(d.x - x);
                                if(distance < dis)
                                {
                                    canPush = false;
                                    break;
                                }
                            }

                            if(canPush)
                            {
                                arr.add(new dot(y,x));
                                if(num == arr.size())
                                {
                                    return dis;
                                }

                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static class dot
    {
        int y;
        int x;

        dot(int y, int x)
        {
            this.y = y;
            this.x = x;
        }
    }




    // 가장 많이 곂칠 때 사람 수를 구하는 함수
    public static int people(int[][] timetable)
    {
        // 시작시간으로 정렬
        Arrays.sort(timetable, (o1, o2) -> o1[0] - o2[0]);

        int result = 0;

        // 끝나는 시간을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < timetable.length; i++)
        {

            while(!pq.isEmpty() && pq.peek() < timetable[i][0])
            {
                int one = pq.poll();
            }
            pq.add(timetable[i][1]);
            result = Math.max(result, pq.size());
        }

        return result;
    }
    
}