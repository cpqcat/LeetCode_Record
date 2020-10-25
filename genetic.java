import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class genetic {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankset = new HashSet<>();
        for (String s : bank) {
            bankset.add(s);
        }
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<>();
        bankset.remove(start);
        char[] change = {'A', 'C', 'G', 'T'};
        q.add(start);
        visited.add(start);
        int idnex = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
            String item = q.poll();
            char[] ArrayItem = item.toCharArray();
            for (int j = 0; j < 8; j++) {
                char tmp = ArrayItem[j];
                for (char c : change) {
                    if (c != tmp) {
                        ArrayItem[j] = c;
                        String str = String.valueOf(ArrayItem);
                        if (bankset.contains(str) && !visited.contains(str)) {
                            q.add(str);
                            visited.add(str);
                            if (str.equals(end)) {
                                return idnex+1;
                            }
                        }
                    }
                }
                ArrayItem[j] = tmp;
            }
            }
            idnex++;
        }
        return -1;

    }
}