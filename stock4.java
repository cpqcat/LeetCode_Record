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

        public int maxProfit1(int[] prices) {
            int [][] dp = new int [prices.length][2];
            if (dp == null || dp.length == 0) return 0; 
            int preprofit0 = 0;
            int profit0 = 0;
            int profit1 = -prices[0];
            
            for (int i = 1; i < prices.length; i++) {
                int tmp = profit0;
                int nextprofit0 = Math.max(profit0,profit1 + prices[i]);
                int nextprofit1 = Math.max(preprofit0 - prices[i], profit1);
                preprofit0 = tmp;
                profit0 = nextprofit0;
                profit1 = nextprofit1;
            }
            return profit0;
        }
}