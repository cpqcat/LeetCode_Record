import java.util.ArrayList;
import java.util.List;

public class generate_parentheses {
    private List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        generate(n, n, "");
        return res;
    }

    void generate(int left, int right, String subres) {
        if (left == 0 && right == 0) {
            res.add(subres);
            return;
        }
        if (left < 0 || right < 0) return;
        if (left > right) return;
        String tmp = subres;
        subres += '(';
        generate(left-1,right,subres);
        subres = tmp;
        subres += ')';
        generate(left,right-1, subres);
    }
}