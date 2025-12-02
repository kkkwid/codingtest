import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        char arr[][] = new char[wallpaper.length][wallpaper[0].length()];
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        
        for(int i=0;i<wallpaper.length; i++){
            arr[i]=wallpaper[i].toCharArray();
            for(int j=0; j<wallpaper[i].length();j++){
                if(arr[i][j]=='#'){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        Collections.sort(x);
        Collections.sort(y);

        int[] result = new int[4];
        
        result[0]=x.get(0);
        result[1]=y.get(0);
        result[2]=x.get(x.size()-1)+1;
        result[3]=y.get(y.size()-1)+1;
        
        return result;
        
    }
}