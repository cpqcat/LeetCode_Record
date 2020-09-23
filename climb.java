public class climb {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1;
        int b = 2;
        int tmp;
        for (int i = n-3; i >= 0; i--) {
            tmp = b;
            b = b + a;
            a = tmp;
        }
        return b;
    }
}
