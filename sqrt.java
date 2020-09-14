class sqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if ((long) mid * mid == x) return mid;
            if ((long) mid * mid < x) {
                left = mid + 1;
            }
            if ((long) mid * mid > x) {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}