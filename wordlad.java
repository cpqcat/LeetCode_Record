import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class wordlad {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                System.out.print(word+"  ");
                char[] charArray = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char original = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        charArray[j] = c;
                        String nextword = String.valueOf(charArray);
                        if (wordSet.contains(nextword)) {
                            if (nextword.equals(endWord)) {
                                return step+1;
                            }
                            if (!visited.contains(nextword)) {
                                queue.add(nextword);
                                visited.add(nextword);
                            }
                        }
                    }
                    charArray[j] = original;
                }
            }
            step++;
            System.out.println("");
        }
        return 0;
    }
}

class my {
    public static void main(String[] args) {
        wordlad w = new wordlad();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        w.ladderLength(beginWord, endWord, wordList);
    }
}