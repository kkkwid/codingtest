class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toSec(video_len);
        int now = toSec(pos);
        int start = toSec(op_start);
        int end = toSec(op_end);
        for (String cmd : commands) {
            if (now >= start && now <= end) now = end;
            if (cmd.equals("prev")) now = Math.max(0, now - 10);
            else now = Math.min(len, now + 10);
            if (now >= start && now <= end) now = end;
        }
        return toStr(now);
    }

    int toSec(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    String toStr(int s) {
        return String.format("%02d:%02d", s / 60, s % 60);
    }
}
