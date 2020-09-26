class robot2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robSub(nums, 0, nums.length-2), robSub(nums, 1, nums.length-1));
    }

    int robSub(int[] nums, int begin, int end) {
        if (nums == null || end-begin < 0) return 0;
        if (end-begin == 0) return nums[begin];
        int a = nums[begin];
        int b = Math.max(a, nums[begin+1]);
        int c;
        for (int i = begin+2; i <= end; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return b;
    }
}