import java.util.*;

class Solution {
    
    ArrayList<int[]> rooms = new ArrayList<>();
    
    public int solution(String[][] book_time) {
        int[][] booking = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++){
            booking[i][0] = changetoMin(book_time[i][0]);
            booking[i][1] = changetoMin(book_time[i][1]) + 10;
        }
        
        Arrays.sort(booking, (o1, o2) -> o1[0] - o2[0]);
        
        rooms.add(booking[0]);
        for(int i=1; i<booking.length; i++){
            int checkin = booking[i][0];
            
            for(int j=0; j<rooms.size(); j++){
                if(checkin >= rooms.get(j)[1]){
                    rooms.remove(j);
                    break;
                }
            }
            
            rooms.add(booking[i]);
        }
        return rooms.size();
    }
    
    int changetoMin(String time){
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    
}