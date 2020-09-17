public class binaryrotated {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                // middle可能是最小值,后面一定是顺序！
                right = middle;
            } else {
                // middle肯定不是最小值，后面是逆序
                left = middle + 1;
            }
        }
        return nums[left];
    }
}
