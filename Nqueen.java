class Nqueen {
    private int count;
    public int totalNQueens(int n) {
        count = 0;
        helper(n, 0, 0, 0, 0);
        return count;

    }
    public void helper(int n, int row, int col, int na, int pie) {
        if (row == n) {
            count++;
            return;
        }
        int available = ((~(col | na | pie)) & ((1 << n) - 1));
        while (available != 0) {
            int pos = available & (-available);
            available = available & (available - 1);
            helper(n, row+1, col | pos, (na | pos) << 1, (pie | pos) >> 1);
        }
    }
}