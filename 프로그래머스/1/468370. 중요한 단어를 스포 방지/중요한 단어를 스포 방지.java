import java.util.*;

class Info {
    int start ;
    int end;
    
    Info (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {

    
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        
        List<Info> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str : message.split(" ")) {
            str = str.trim();
            if (!str.isEmpty()) map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        
        for (int i=0; i<spoiler_ranges.length; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            
            Info info = new Info(start, end);
            moveStart(info,message);
            moveEnd(info, message);
            
            list.add(info);
        }
        
        list.sort((a,b) -> a.start - b.start);

        List<Info> merged = new ArrayList<>();

        for (Info info : list) {
            if (merged.isEmpty()) {
                merged.add(info);
                continue;
            }
            
            Info prev = merged.get(merged.size()-1);
            
            if (prev.end >= info.start) {
                prev.end = Math.max(prev.end, info.end);
            }
            else {
                merged.add(info);
            }
        }
        
        list = merged;
        
        Map<String, Integer> secretMap = new HashMap<String, Integer>();
        
        for (Info info : list) {

            String[] arr = message.substring(info.start, info.end+1).trim().split(" ");
            for (String str : arr) {
                str = str.trim();
                if (str.isEmpty()) continue;
                secretMap.put(str, secretMap.getOrDefault(str, 0) + 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : secretMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            
            if (map.containsKey(key) && map.get(key) == value) answer++;
        }
        
        return answer;
    }

    
    void moveStart(Info info, String message) {

        if (message.charAt(info.start) == ' ') return;

        while (info.start > 0 && message.charAt(info.start - 1) != ' ') {
            info.start--;
        }

    }
    
    void moveEnd(Info info, String message) {

        if (message.charAt(info.end) == ' ') return;

        while (info.end < message.length()-1 && message.charAt(info.end + 1) != ' ') {
            info.end++;
        }

    }
}