class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
		long maxy = 0;
		for (long x = 0; x <= d; x += k) {
			maxy = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
			answer += (maxy / k) + 1;
		}
        
        return answer;
    }
}