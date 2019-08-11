import java.util.ArrayList;
import java.util.Stack;

class LeetCode695 {
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int maxAreaOfIsland(int[][] grid) {
            int area = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        area = Math.max(area, findMax(grid, i, j));
                    }
                }
            }

            return area;
        }

        private int findMax(int[][] grid, int i, int j) {
            int area =1;
            grid[i][j] = -1;
            for (int[] dir : dirs) {
                if (i + dir[0] < grid.length &&
                        j + dir[1] < grid[0].length &&
                        i + dir[0] >= 0 &&
                        j + dir[1] >= 0 &&
                        grid[i+dir[0]][j+dir[1]]  == 1

                ) {
                    area+= findMax(grid,i+ dir[0],j+dir[1]);
                }
            }

            return area;
        }

    }


}