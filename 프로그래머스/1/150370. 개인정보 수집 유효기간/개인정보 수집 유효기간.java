import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            String[] term = t.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacie = privacies[i].split(" ");
            if (getTotalDays(privacie[0]) + map.get(privacie[1]) * 28 <= getTotalDays(today)){
                list.add(i + 1);
            }
            
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public int getTotalDays(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}