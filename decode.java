class decode {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = (s.charAt(0) != '0') ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            int a = 0, b = 0;
            int num = Integer.parseInt(s.substring(i-1,i+1));
            if ( 10 <= num && num <= 26) {
                a = i-2>=0 ? dp[i-2] : 1;
            }
            if (s.charAt(i) != '0') {
                b = dp[i-1];
            }
            dp[i] = a + b;
        }
        return dp[s.length()-1];
    }
}