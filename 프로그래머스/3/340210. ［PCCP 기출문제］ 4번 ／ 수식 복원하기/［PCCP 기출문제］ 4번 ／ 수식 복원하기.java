import java.util.*;

class Solution {

    public String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>(); 
        List<List<String>> questions = new ArrayList<>();
        boolean[] candidate = new boolean[10]; 
        
        Arrays.fill(candidate, true);
        
        for (String str : expressions) {
            List<String> list = parse(str);

            if (list.get(4).equals("X")) {
                questions.add(list);
            } 
            
            for (int k=2; k<=9; k++) {
                if (candidate[k]) {
                    candidate[k] = isValidK(k, list.get(0), list.get(2), list.get(4), list.get(1));
                }
            }
        }
        
        for (List<String> q : questions) {
            boolean flag = true; 
            String c = ""; 
            
            for (int k=2; k<=9; k++) {
                if (!candidate[k]) continue;
                
                String a = q.get(0);
                String b = q.get(2);
                String op = q.get(1);
                int res = calc(changeKtoTen(k, a), changeKtoTen(k, b), op);
                
                if (c.isEmpty()) {
                    c = changeTentoK(k, res);
                } else {
                    if (!c.equals(changeTentoK(k, res))) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) q.set(4, c);
            else q.set(4, "?");
            
            String str = String.join(" ", q); 
            answer.add(str);
        }
        
        return answer.stream().toArray(String[]::new);
    }
    
    public List<String> parse(String str) {
        String[] strArr = str.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(strArr));
        
        return list;
    }
    
    public int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else return a - b;
    }
    
    public String changeTentoK(int k, int x) {
        if (x == 0) return "0";
        
        String ret = "";
        
        while (x > 0) {
            ret += x % k;
            x /= k;
        }
        
        StringBuilder sb = new StringBuilder(ret);
        return sb.reverse().toString();
    }
    
    public int changeKtoTen(int k, String x) {        
        int d = 1;
        int sum = 0;
        
        for (int i=x.length()-1; i>=0; i--) {
            sum += (x.charAt(i) - '0') * d;
            d *= k;
        }
        
        return sum;
    }
    
    public boolean isValidK(int k, String a, String b, String c, String op) {
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i)-'0' >= k) return false;
        }
        
        for (int i=0; i<b.length(); i++) {
            if (b.charAt(i)-'0' >= k) return false;
        }
        
        if (c.equals("X")) return true;
        else {
            for (int i=0; i<c.length(); i++) {
                if (c.charAt(i)-'0' >= k) return false;
            }
        }
        
        return changeKtoTen(k, c) == calc(changeKtoTen(k, a), changeKtoTen(k, b), op);
    }
    
}