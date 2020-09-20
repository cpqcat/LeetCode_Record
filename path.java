class path {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int [m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (col == 0 && row == 0) {
                    memo[row][col] = 1;
                    continue;
                }
                int left = col > 0 ? memo[row][col-1] : 0;
                int top = row > 0 ? memo[row-1][col] : 0;
                memo[row][col] = left + top;
            }
        }
        return memo[m-1][n-1];
    }
}