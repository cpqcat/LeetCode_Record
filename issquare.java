class issquare {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == num) return true;
            if ((long) mid * mid < num) left = mid + 1;
            if ((long) mid * mid > num) right = mid - 1;
        }
        return false;
    }
}