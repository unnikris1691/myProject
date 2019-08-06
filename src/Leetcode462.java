import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Leetcode462 {
    class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int islandPerimeter(int[][] grid) {
            int a = grid[0][0];
            return calculatePerimeter(0, 0, grid);

        }

        private int calculatePerimeter(int i, int j, int[][] grid) {
            grid[i][j] = -1;
            int m = grid.length;
            int n = grid[i].length;
            int count = 0;

            for (int[] dir : dirs) {
                int nextI = dir[0] + i;
                int nextJ = dir[1] + j;
                if (nextI > m - 1 || nextI < 0 || nextJ > n - 1 || nextJ < 0 || grid[nextI][nextJ] == 0) {
                    count++;
                } else {
                    count += calculatePerimeter(nextI, nextJ, grid);
                }
            }
            return count;

        }
    }


}