import java.util.Arrays;

public class food {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < s.length && j < g.length) {
            if (g[j] <= s[i]) {
                i ++;
                j ++;
                res ++;
            }
            else {
                i ++;
            }
        }
        return res;
    }
}
