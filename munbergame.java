class numbergame {
    public boolean isValidSudoku(char[][] board) {
        int[][] cols = new int[9][10];
        int[][] rows = new int[9][10];
        int[][] boxs = new int[9][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (rows[i][num] == 1) return false;
                    rows[i][num] = 1;
                    if (cols[j][num] == 1) return false;
                    cols[j][num] = 1;
                    if (boxs[(i/3)*3+j/3][num] == 1) return false;
                    boxs[(i/3)*3+j/3][num] = 1;
                }
            }
        }
        return true;
    }
}