import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<String> skillList = new ArrayList();

        for(int i = 0; i<skill.length(); i++)
            skillList.add(skill.substring(i, i+1));

        for(String str : skill_trees){
            int cnt = 0;
            int check = 0;
            for(int i = 0; i<str.length(); i++){
                String tmp = str.substring(i, i+1);

                if(skillList.indexOf(tmp) > cnt){
                    check = 1;
                    break;
                }

                if(skillList.indexOf(tmp) == cnt){
                    cnt++;
                }
            }

            if(check == 0) answer++;
        }

        return answer;
    }
}
