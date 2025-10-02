import java.io.*;
import java.util.*;

class Solution {
    static class cell{
        String val = null;
        public String toString(){
            return val;
        }
    }
    void merge(int r1, int r2, int r3, int r4){
        cell c = table[r1][r2];
        for(int i=0; i<50; i++)
            for(int j=0; j<50; j++)
                if(table[i][j] == c)
                    table[i][j] = table[r3][r4];
    }
    static cell[][] table;
    public String[] solution(String[] commands) {
        String[] answer;
        List<String> ans = new ArrayList<>();
        table = new cell[50][50];
        for(int i=0; i<50; i++)
            for(int j=0; j<50; j++)
                table[i][j] = new cell();
        for(String command : commands){
            String[] c = command.split(" ");
            if(c[0].equals("UPDATE")){
                if(c.length == 4){
                    int r1 = Integer.parseInt(c[1])-1; int c1=Integer.parseInt(c[2])-1;
                    table[r1][c1].val = c[3];
                }
                else{
                    for(int i=0; i<50; i++)
                        for(int j=0; j<50; j++)
                            if(table[i][j].val != null && table[i][j].val.equals(c[1]))
                                table[i][j].val = c[2];
                }
            }
            else if(c[0].equals("MERGE")){
                int r1 = Integer.parseInt(c[1])-1; int c1=Integer.parseInt(c[2])-1;
                int r2 = Integer.parseInt(c[3])-1; int c2=Integer.parseInt(c[4])-1;
                if(table[r1][c1] == table[r2][c2]) continue;
                if(table[r1][c1].val == null && table[r2][c2].val != null)
                    merge(r1, c1, r2, c2);
                else if(table[r2][c2].val == null && table[r1][c1].val != null)
                    merge(r2, c2, r1, c1);
                else
                    merge(r2, c2, r1, c1);
                table[r2][c2] = table[r1][c1];
            }
            else if(c[0].equals("UNMERGE")){
                int r1 = Integer.parseInt(c[1])-1; int c1=Integer.parseInt(c[2])-1;
                cell del = table[r1][c1];
                for(int i=0; i<50; i++)
                    for(int j=0; j<50; j++)
                        if(table[i][j] == del)
                            table[i][j] = new cell();
                if(del.val != null)
                    table[r1][c1].val = del.val;
            }
            else if(c[0].equals("PRINT")){
                int r1 = Integer.parseInt(c[1])-1; int c1=Integer.parseInt(c[2])-1;
                ans.add(table[r1][c1].val == null ? "EMPTY" : table[r1][c1].val);
            }
        }
        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
    }
}