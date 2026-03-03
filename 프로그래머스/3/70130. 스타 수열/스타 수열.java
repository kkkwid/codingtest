import java.util.*;
class Solution {
    public int solution(int[] a) {
        
        int[] numbers = new int[a.length];
        LinkedList<Intersection> list = new LinkedList<Intersection>();
        int maxLen = 0;
        for(int i = 0; i<a.length; i++){
            numbers[a[i]]++;
        }
        for(int i = 0; i<a.length; i++){
            if(numbers[i] != 0)
                list.add(new Intersection(i, numbers[i]));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i<list.size(); i++){
            Intersection now = list.get(i);
            if(maxLen > now.count){
                return maxLen * 2;
            }
            int len = 0;
            int remain = -1;
            for(int j = 0; j<a.length; j++){
                if(len >= now.count ){
                    return now.count * 2;
                }
                if(a[j] == now.number){
                    remain = j;
                    continue;
                }
                if(remain != -1){
                    len++;
                    remain = -1;
                    continue;
                }
                if(j+1 < a.length && a[j+1] == now.number){
                    len++;
                    j++;
                    remain = -1;
                }
            }
            if(maxLen < len)
                maxLen = len;
        }    
        return maxLen * 2;
    }
    
}
class Intersection implements Comparable<Intersection>{
    int count;
    int number;
    
    public Intersection(int number, int count){
        this.number = number;
        this.count = count;
    }
    
    public int compareTo(Intersection i){
        return i.count - this.count;
    }
}