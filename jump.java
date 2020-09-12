class jump {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[0] = true;
        for (int i = 0; i < nums.length; i ++) {
            if (memo[i] == true) {
                for (int j = i + 1; j <= i+nums[i] && j < nums.length; j ++) {
                    memo[j] = true;
                }
            }
        }
        return memo[nums.length - 1] == true;
    }
}