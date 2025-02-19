import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<> ();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        if(nums.length/2 < set.size()){
            result = nums.length/2;
            return result;
        }
        
        return set.size();
    }
}