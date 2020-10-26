import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class gentic2 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankset = new HashSet<>();
        for (String s : bank) {
            bankset.add(s);
        }
        Queue<String> q = new LinkedList<String>();

        Set<String> beginset = new HashSet<>();
        Set<String> endset = new HashSet<>();
        Set<String> newset = new HashSet<>();

        Set<String> visited = new HashSet<>();
        //bankset.remove(start);
        //bankset.remove(end);
        char[] change = {'A', 'C', 'G', 'T'};
        beginset.add(start);
        endset.add(end);

        visited.add(start);
        int idnex = 0;
        while (beginset.size() > 0 && endset.size() > 0) {
            if (beginset.size() > endset.size()) {
                    Set<String> tmpset = new HashSet<>(beginset);
                    beginset = endset;
                    endset = tmpset;
            }


            for (String item : beginset) {
            char[] ArrayItem = item.toCharArray();
            for (int j = 0; j < 8; j++) {
                char tmp = ArrayItem[j];
                for (char c : change) {
                    if (c != tmp) {
                        ArrayItem[j] = c;
                        String str = String.valueOf(ArrayItem);
                            if (bankset.contains(str) && endset.contains(str)) {
                                return idnex+1;
                            }
                        if (bankset.contains(str) && !visited.contains(str)) {
                            newset.add(str);
                            visited.add(str);
                        }
                    }
                }
                ArrayItem[j] = tmp;
            }
            }
            beginset = new HashSet<>(newset);
            newset.clear();
            idnex++;
        }
        return -1;

    }
}

class gentic2test{
    public static void main(String[] args) {
        gentic2 gen = new gentic2();
        String start =  "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {};
        gen.minMutation(start, end, bank);
    }
}

