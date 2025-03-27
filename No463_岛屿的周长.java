/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No463_岛屿的周长 {
    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        System.out.println(solution463.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }
}

class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return islandPerimeterCore(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int islandPerimeterCore(int[][] grid, int i, int j) {
        // 边界和水贡献1
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        return islandPerimeterCore(grid, i - 1, j) +
                islandPerimeterCore(grid, i + 1, j) +
                islandPerimeterCore(grid, i, j - 1) +
                islandPerimeterCore(grid, i, j + 1);
    }
}
