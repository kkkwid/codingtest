import java.util.*;

class Solution {
    private Map<String, Integer> parkingLot = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] r = record.split(" ");
            int minute = getMinute(r[0]);
            if (r[2].equals("IN")) { 
                minute *= -1;
            } else {
                minute *= 1;
            }

            parkingLot.put(r[1], parkingLot.getOrDefault(r[1], 0) + minute);
        }

        for (String carNumber : parkingLot.keySet()) {
            if (parkingLot.get(carNumber) < 1) { 
                parkingLot.put(carNumber, parkingLot.get(carNumber) + 1439);
            }
        }

        String[] carNumbers = parkingLot.keySet().toArray(new String[0]);
        Arrays.sort(carNumbers);

        int[] answer = new int[carNumbers.length];
        for (int i = 0; i < carNumbers.length; i++) {
            int m = parkingLot.get(carNumbers[i]);
            answer[i] = calculateParkingFee(fees, m);
        }
        return answer;
    }

    private int getMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private int calculateParkingFee(int[] fees, int minute) {
        int fee = fees[1];
        minute -= fees[0];

        if (minute > 0) { 
            if (minute % fees[2] == 0) {
                fee += minute / fees[2] * fees[3];
            } else {
                fee += (minute / fees[2] + 1) * fees[3];
            }
        }
        return fee;
    }
}