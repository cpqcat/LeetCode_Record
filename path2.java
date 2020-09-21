class path2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int memo[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    memo[j] = 0;
                }
                else {
                    if (i == 0 && j == 0) {
                        memo[j] = 1;
                        continue;
                    }
                    int left = j > 0 ? memo[j-1] : 0;
                    int top =  i > 0 ? memo[j] : 0;
                    memo[j] = left + top;
                }
            }
        }
        return memo[n-1];
    }
}