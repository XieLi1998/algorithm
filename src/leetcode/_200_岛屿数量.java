package leetcode;

/**
 * Created by xieli on 2021/3/28.
 */
public class _200_岛屿数量 {

    /**
     * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 题目限制只有一个岛屿，计算一个即可
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c))
            return;

        if (grid[r][c] != '1')
            return;

        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

}
