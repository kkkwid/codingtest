class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0, l = 0, r = -1, len = 1000000;
        while(r<sequence.length) {
            if(sum<k) {
                if(++r < sequence.length) sum += sequence[r];
            }
            else if(sum>k) {
                sum -= sequence[l++];
            }
            else if(sum==k) {
                if(r-l < len || (r-l == len && r<answer[1])) {
                    answer[0] = l;answer[1] = r;len = r-l;
                }
                sum -= sequence[l++];
            }
        }
        return answer;
    }
}