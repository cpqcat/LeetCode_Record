public class surrounded {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        UnionFind uf = new UnionFind(row*col+1);
        int dummyNode = row*col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == row-1 || j == 0 || j == col-1) {
                        uf.Union(i*col+j,dummyNode);
                    }
                    else {
                        if (i > 0 && board[i-1][j] == 'O')
                        uf.Union(i*col+j, (i-1)*col+j);
                        if (j > 0 && board[i][j-1] == 'O')
                        uf.Union(i*col+j, (i)*col+j-1);
                        if (i+1 <= col-1 && board[i+1][j] == 'O')
                        uf.Union(i*col+j, (i+1)*col+j);
                        if (j+1 <= col-1 && board[i][j+1] == 'O')
                        uf.Union(i*col+j, i*col+j+1);
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (uf.findParent(i*col+j) == uf.findParent(row*col)) {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }

    }
}

class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }

    int findParent(int node) {
        while(parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    void Union(int i, int j) {
        int iParent = findParent(i);
        int jParent = findParent(j);

        if (iParent != jParent) {
            parents[jParent] = iParent;
        }
    }
}
