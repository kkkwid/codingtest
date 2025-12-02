import java.util.*;
import java.util.function.Function;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        List<String> candidates = generateCandidates();

        while (candidates.size() > 1) {
            String guess = candidates.get(0);
            String result = submit.apply(Integer.parseInt(guess));

            candidates = filterCandidates(candidates, guess, result);

            if (candidates.isEmpty()) break;
        }

        return Integer.parseInt(candidates.get(0));
    }

    private List<String> generateCandidates() {
        List<String> list = new ArrayList<>();
        for (int a = 1; a <= 9; a++)
            for (int b = 1; b <= 9; b++)
                if (a != b)
                    for (int c = 1; c <= 9; c++)
                        if (c != a && c != b)
                            for (int d = 1; d <= 9; d++)
                                if (d != a && d != b && d != c)
                                    list.add("" + a + b + c + d);
        return list;
    }

    private List<String> filterCandidates(List<String> list, String guess, String result) {
        List<String> filtered = new ArrayList<>();

        int strike = result.charAt(0) - '0';
        int ball = result.charAt(3) - '0';

        for (String cand : list) {
            int[] res = compare(guess, cand);
            if (res[0] == strike && res[1] == ball)
                filtered.add(cand);
        }

        return filtered;
    }

    private int[] compare(String guess, String target) {
        int s = 0, b = 0;
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                s++;
            } else if (target.contains(String.valueOf(guess.charAt(i)))) {
                b++;
            }
        }
        return new int[]{s, b};
    }
}
