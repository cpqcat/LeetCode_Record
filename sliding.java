import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class sliding {
    public int slidingPuzzle(int[][] board) {
        int[][] map = new int[][] {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };

        Queue<String> q = new LinkedList<>();
        char[] chars = new char[6];
        Set<String> visited = new HashSet<String>();
        String target = "123450";
        int index = 0;
        int step = 0;
        for (int[] row : board) {
            for (int i : row) {
                chars[index++] = (char)(i+'0');
            }
        }
        q.offer(String.valueOf(chars));
        visited.add(String.valueOf(chars));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                int pos = cur.indexOf('0');
                int[] neibor = map[pos];
                for (int item : neibor) {
                    String str = excange(cur, pos, item);
                    if (!visited.contains(str)) {
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
            step++;
        }
    return -1;
    }

    String excange(String cur, int pos, int item) {
        char[] chars = cur.toCharArray();
        char tmp = chars[item];
        chars[item] = chars[pos];
        chars[pos] = tmp;
        return new String(chars);
    }
}
