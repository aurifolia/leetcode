package round1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 *
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 *
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No827_最大人工岛 {
}

class Solution827 {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int color = 2;
        Map<Integer, Integer> colorMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    colorMap.put(color, dfs(grid, i, j, color));
                    color++;
                }
            }
        }
        int max = colorMap.getOrDefault(2, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> colors = new HashSet<>();
                    if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                        colors.add(grid[i - 1][j]);
                        cur += colorMap.get(grid[i - 1][j]);
                    }
                    if (i + 1 < m && grid[i + 1][j] != 0 && !colors.contains(grid[i + 1][j])) {
                        colors.add(grid[i + 1][j]);
                        cur += colorMap.get(grid[i + 1][j]);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != 0 && !colors.contains(grid[i][j - 1])) {
                        colors.add(grid[i][j - 1]);
                        cur += colorMap.get(grid[i][j - 1]);
                    }
                    if (j + 1 < n && grid[i][j + 1] != 0 && !colors.contains(grid[i][j + 1])) {
                        colors.add(grid[i][j + 1]);
                        cur += colorMap.get(grid[i][j + 1]);
                    }
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j, int color) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = color;
        return 1 + dfs(grid, i - 1, j, color)
                + dfs(grid, i + 1, j, color)
                + dfs(grid, i, j - 1, color)
                + dfs(grid, i, j + 1, color);
    }
}
