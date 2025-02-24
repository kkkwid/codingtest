class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i<nums.length; i++){
            int sum = 0;
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    sum = nums[i]+nums[j]+nums[k];
                    for(int l = 2; l < sum; l++){
                        if(sum % l == 0){
                            break;
                        }
                        else if(l == sum-1){
                            answer++;
                        }
                    }
                }
                
            }
        }
        return answer;
    }
}