class Solution {
    int m, n;
    int islands;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(dfs(grid, i, j, visited)) islands++;
                }
            }
        }
        return islands;
    }
    public boolean dfs(int[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || y < 0 || x >= m || y >= n) return false;

        if(visited[x][y] || grid[x][y] == 1) return true;
        
        visited[x][y] = true;

        boolean up = dfs(grid, x + 1, y, visited);
        boolean down = dfs(grid, x - 1, y, visited);
        boolean right = dfs(grid, x, y + 1, visited); 
        boolean left = dfs(grid, x, y - 1, visited);
        return up && down && right && left;
    }
}