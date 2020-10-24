import java.util.Arrays;

public class island {
    int find(int[] parent, int i) {
        if (parent[i] == -1){
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int[] parent, int i, int j) {
        int iset = find(parent, i);
        int jset = find(parent, j);
        if (jset != iset) {
            parent[jset] = iset;
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] parent = new int[row*col];
        Arrays.fill(parent, -2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    parent[i*col + j] = -1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 0;
                    if (i - 1 >= 0 && grid[i-1][j] == '1') {
                        union(parent, i * col + j, (j-1) * col + j);
                    }
                    if (i + 1 < row && grid[i+1][j] == '1') {
                        union(parent, i * col + j, (i+1) * col + j);
                    }
                    if (j - 1 >= 0 && grid[i][j-1] == '1') {
                        union(parent, i * col + j, i * col + j - 1);
                    }
                    if (j + 1 < col && grid[i][j+1] == '1') {
                        union(parent, i * col + j, i * col + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (parent[i*col + j] == -1) {
                    count++;
                }
            }
        }
        return count;
    }
}
