class stockFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit1(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int p0 = 0;
        int p1 = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            int tmp0 = Math.max(p0, p1 + prices[i]);
            int tmp1 = Math.max(p1, p0 - prices[i] - fee);
            p0 = tmp0;
            p1 = tmp1;
        }
        return p0;
    }
}