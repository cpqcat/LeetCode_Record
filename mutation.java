import java.util.HashSet;

class mutation {
    int minStep = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        helper(start,0, new HashSet<String>(), end, bank);
        return (minStep == Integer.MAX_VALUE) ? -1 : minStep;
    }
    void helper(String current, int step, HashSet<String> set, String end, String[] bank) {
        if (current.equals(end)) {
            minStep = Math.min(step, minStep);
            return;
        }
        for (String s : bank) {
            if (!set.contains(s) && isOneDiff(current, s)) {
                set.add(s);
                helper(s, step + 1, set, end, bank);
                set.remove(s);
            }
        }
    }
    boolean isOneDiff(String current, String s) {
        int diff = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != s.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        if (diff == 0) return false;
        return true;
    }
}
