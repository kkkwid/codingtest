import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int n = sequence.length;
        List<long[]> pres = List.of(new long[n], new long[n]);
        List<List<Integer>> locations = new ArrayList<>();
        
        for(int k=0; k<2; k++){    
            long[] pre = pres.get(k); 
            pre[0] = pulseMultiNumber(k, 0, sequence);
            
            long maxValue = pre[0];
            int maxLocation = 0;
            List<Integer> maxs = new ArrayList<>();
            maxs.add(maxLocation);
            
            for(int i=1; i<n; i++){
                long t = pulseMultiNumber(k, i, sequence);
                pre[i] += (pre[i-1] + t); 
                    
                if(maxValue < pre[i]){ 
                    maxValue = pre[i];
                    maxLocation = i;
                    maxs = new ArrayList<>();
                    maxs.add(maxLocation);
                }else if(maxValue == pre[i]){
                    maxs.add(i);
                }
            }
            
            locations.add(maxs);
        }
        
        for(int k=0; k<2; k++){    
            long[] pre = pres.get(k);
            List<Integer> los = locations.get(k);
            
            for(int lo : los){
                long sum = 0;
                long t = 0;
                for(int i=lo; i>=0; i--){
                    sum += pulseMultiNumber(k, i, sequence);
                    answer = Math.max(answer, sum);
                }
            }
        }
        
        return answer;
    }
    
    private long pulseMultiNumber(int k, int i, int[] sequence){
        long t;
        if(i % 2 == 0) { 
            t = (k == 0) ? (sequence[i] * -1) : sequence[i];
        } else { 
            t = (k == 0) ? sequence[i] : (sequence[i] * -1);
        }
        return t;
    }
}