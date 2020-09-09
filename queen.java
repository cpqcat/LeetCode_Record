import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        queen q = new queen();
        List<List<String>> res = q.solveNQueens(4);
        for (List<String> item : res) {
            for (String s : item) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
class queen {
    public List<List<String>> solveNQueens(int n) {
        int[] positions = new int[n];
        List<List<String>> res = new ArrayList<List<String>>();
        helper(res, positions, 0, n);
        return res;
    }
    void helper(List<List<String>> res, int[] positions, int col, int n) {
        if (col == n) {
            res.add(arry2List(positions, n));
        }
        for (int i = 0; i < n; i++) {
            if (isOK(col, i, positions)){
                positions[col] = i;
                helper(res, positions, col + 1, n);
            }
        }
    }

    List<String> arry2List(int [] positions, int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < positions.length; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[positions[i]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }
    boolean isOK(int col, int i, int[] positions) {
        for (int j = 0; j < col; j++) {
            if (positions[j] == i) return false;
            if (col - i == j - positions[j]) return false;
            if (col + i == positions[j] + j) return false;
        }
        return true;
    }
}