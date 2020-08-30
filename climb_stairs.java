import java.util.HashMap;

public class climb_stairs {
    // recursive and memory
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo.containsKey(n) != true) {
            int temp = climbStairs(n-1) + climbStairs(n-2);
            memo.put(n, temp);
        }
        return memo.get(n);
    }

    // iterative
    public int climbStairs_iterative(int n) {
        int [] memo = new int [n+1];
        if (n <= 2) return n;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}