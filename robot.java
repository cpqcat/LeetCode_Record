class robot {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int a = nums[0];
        int b = Math.max(a, nums[1]);
        int c = 0;
        for (int i= 2; i < nums.length; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}