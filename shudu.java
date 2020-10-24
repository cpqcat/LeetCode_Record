class shudu {
    private char[][] _board;
    private int[][] cols;
    private int[][] rows;
    private int[][] boxs;
    boolean isEnd;
    public void solveSudoku(char[][] board) {
        _board = board;
        cols = new int[9][10];
        rows = new int[9][10];
        boxs = new int[9][10];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int num = _board[row][col] - '0';
                if (_board[row][col] != '.') {
                cols[col][num] = 1;
                rows[row][num] = 1;
                boxs[row/3*3 + col/3][num] = 1; 
                }
            }
        }
        recurrse(0, "");
        board = _board;
    }

    void recurrse(int index, String space) {
        if (index == 81) isEnd = true;
        if (isEnd) return;
        while (_board[index/9][index%9] != '.') {   
            index++;
            if (index == 81) {
                isEnd = true;
                return;
            }
        }
        for (int i = 1; i <= 9 && !isEnd; i++) {
            if(valiate(index,i)) {
            int row = index/9;
            int col = index%9;
            cols[col][i] = rows[row][i] = boxs[row/3*3+col/3][i] = 1;
            _board[index/9][index%9] = (char)(i+'0');
            System.out.println(space+":" + row + col + " " + i);
            recurrse(index+1, space+"  ");
            // if (isEnd == true) return;
            // _board[index/9][index%9] = '.';
            cols[col][i] = rows[row][i] = boxs[row/3*3+col/3][i] = 0;
            }
        }
    }
    boolean valiate(int index, int i) {
        int row = index/9;
        int col = index%9;
        return cols[col][i] == 0 && rows[row][i] == 0 && boxs[row/3*3+col/3][i] == 0;
    }
}

class hh {
    public static void main(String[] args) {
        shudu s = new shudu();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        s.solveSudoku(board);
    }
}