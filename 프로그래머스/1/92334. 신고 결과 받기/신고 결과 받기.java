import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportId = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();
        ArrayList<String> stopId = new ArrayList<>();

        //신고 리스트
        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            HashSet<String> set;

            if(reportId.containsKey(temp[0])){
                set = reportId.get(temp[0]);
            }
            else{
                set = new HashSet<>();
            }
            int size = set.size();
            set.add(temp[1]);
            if(size != set.size()){
                reportCount.put(temp[1], reportCount.getOrDefault(temp[1], 0) + 1);
            }
            reportId.put(temp[0], set);
        }

        //정지 id
        for(String temp : reportCount.keySet()){
            if(reportCount.get(temp) >= k){
                stopId.add(temp);
            }
        }

        //email
        for (int i = 0; i < id_list.length; i++) {
            for (int j = 0; j < stopId.size(); j++) {
                String id = stopId.get(j);
                if(reportId.containsKey(id_list[i])){
                    HashSet<String> setList = reportId.get(id_list[i]);
                    if(!setList.isEmpty() && setList.contains(id)){
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
}