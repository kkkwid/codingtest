class Solution {

    public int solution(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = 1;    
            int len2 = 0;    
            int left1 = i - 1, right1 = i + 1;
            int left2 = i, right2 = i + 1;

            boolean flag1 = true;
            boolean flag2 = true;

            while (flag1 || flag2) {
                if (flag1 && left1 >= 0 && right1 < s.length() && s.charAt(left1--) == s.charAt(right1++)) {
                    len1 += 2;
                } else flag1 = false;

                if (flag2 && 
                    left2 >= 0 && 
                    right2 < s.length() && 
                    s.charAt(left2--) == s.charAt(right2++)) {
                    len2 += 2;
                } else flag2 = false;
            }
            max = Math.max(max, Math.max(len1, len2));
        }

        return max;
    }

}