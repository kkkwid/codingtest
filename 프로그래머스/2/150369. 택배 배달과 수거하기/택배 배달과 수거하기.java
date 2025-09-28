import java.util.Arrays;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dstart = n - 1;
        int pstart = n - 1;
    
        int dtotal = Arrays.stream(deliveries).sum();
        int ptotal = Arrays.stream(pickups).sum();
        
        while(true) {
            int dcap = cap;
            int pcap = cap;
            int index = -1;
            
            for(int i = dstart; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    index = Math.max(index, i);
    
                    if (deliveries[i] <= dcap) {
                        dcap -= deliveries[i];
                        dtotal -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= dcap;
                        dstart = i;
                        dtotal -= dcap;
                        break;
                    }
                }
            }
            
            for(int i = pstart; i >= 0; i--) {
                if (pickups[i] > 0) {
                    index = Math.max(index, i);
    
                    if (pickups[i] <= pcap) {
                        pcap -= pickups[i];
                        ptotal -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= pcap;
                        pstart = i;
                        ptotal -= pcap;
                        break;
                    }
                }
            }
            
            if (index >= 0) {
                answer += (index + 1) * 2;
            }
            if (dtotal == 0 && ptotal == 0) {
                break;
            }
            
        }
        return answer;
    }
}