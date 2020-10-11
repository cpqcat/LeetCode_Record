class square {
    public int maximalSquare(char[][] matrixc) {
        if (matrixc == null || matrixc.length == 0) return 0;
        int[][] matrix = new int[matrixc.length][matrixc[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = matrixc[i][0] - '0';
            if (matrix[i][0] == 1) res = 1;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = matrixc[0][j] - '0';
            System.out.println(matrix[0][j]);
            if (matrix[0][j] == 1) res = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrixc[i][j] == '1') {
                matrix[i][j] = 1 + Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                }
                else {
                    matrix[i][j] = 0;
                }
                res = Math.max(res, matrix[i][j]);
            }
        }
        return res*res;
    }
public static void main(String[] args) {
    char[][] c = {{'0','1'}};
    square s = new square();
    s.maximalSquare(c);
}
}

