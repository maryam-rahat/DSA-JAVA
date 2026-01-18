class Solution {
    int m, n, count;
    int max_area = 0;
    

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, visited);
                    max_area = Math.max(area, max_area);
                    
                } 
            }
        }
        return max_area;
    }

    public int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n) return 0;
        
        if (visited[x][y] || grid[x][y] == 0) return 0;

        visited[x][y] = true;

        int area = 1;
        area += dfs(grid, x + 1, y, visited);
        area += dfs(grid, x - 1, y, visited);
        area += dfs(grid, x, y + 1, visited);
        area += dfs(grid, x, y - 1, visited);
        return area;
    }
}