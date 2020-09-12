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

    public boolean canJump2(int[] nums) {
        if (nums == null) return false;
        int endReachable = nums.length - 1;
        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}