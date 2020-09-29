class stock4 {
    public int maxProfit(int[] prices) {
        int [][] dp = new int [prices.length][2];
        if (dp == null || dp.length == 0) return 0; 
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max((i >=2 ? dp[i-2][0]  : 0) - prices[i], dp[i-1][1]);
        }
        return dp[prices.length - 1][0];
    }
}