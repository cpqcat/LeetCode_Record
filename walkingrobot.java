import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direx[] = {0, 1, 0, -1};
        int direy[] = {1, 0, -1, 0};
        int currenti = 0;
        int x = 0, y = 0;

        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            long ix = (long) obstacle[0] + 30000;
            long iy = (long) obstacle[1] + 30000;
            obstacleSet.add((ix << 16) + iy);
        }

        int res = 0;
        for (int command : commands) {
            if (command == -2) {
                currenti = (currenti + 3) % 4;
            }
            else if (command == -1) {
                currenti = (currenti + 1) % 4;
            }
            else {
                for (int i = 0; i < command; i++) {
                    int nx = x + direx[currenti];
                    int ny = y + direy[currenti];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x*x +y*y);
                    }
                }
            }
        }
        return res;
    }
}