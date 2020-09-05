public class majority_element {
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left)/2;
        int leftVal = helper(nums, left, mid);
        int rightVal = helper(nums, mid + 1, right);
        if (leftVal == rightVal) return leftVal;
        else {
            int leftCount = countNum(leftVal, nums, left, right);
            int rightCount = countNum(rightVal, nums, left, right);
            return leftCount > rightCount ? leftVal : rightVal;
        }
    }

    int countNum(int val, int[] nums, int left, int right) {
        int count = 0;
        for (int num : nums) {
            if (num == val)
            count++;
        }
        return count;
    }

    
}
