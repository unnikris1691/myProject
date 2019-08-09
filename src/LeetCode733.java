import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class LeetCode733 {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int[][] floodFill(int[][] grid, int r0, int c0, int color) {
            if (grid[r0][c0] != color) {
                dfs(grid, r0, c0, grid[r0][c0], color);
            }

            return grid;
        }

        private void dfs(int[][] grid, int r0, int c0, int color, int newColor) {
            if (grid[r0][c0] == color) {
                grid[r0][c0] = newColor;


                    for (int[] dir : dirs) {
                        if (r0 > 0 && c0 > 0 && r0  < grid.length -1 && c0  < grid[0].length -1) {
                        dfs(grid, r0 + dir[0], c0 + dir[1], color, newColor);
                    }
                }

            }

        }
    }


}