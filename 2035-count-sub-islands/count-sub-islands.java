class Solution {
    int m, n, island = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid2.length;
        n = grid2[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && !visited[i][j]){
                    if(dfs(grid1, grid2, i, j, visited)) island++;
                }
            }
        }
        return island;
    }
    public boolean dfs(int[][] grid1, int[][] grid2, int x, int y, boolean[][] visited){
        if(x < 0 || y < 0 || x >= m || y >= n) return true;
        if(visited[x][y] || grid2[x][y] == 0) return true;

        visited[x][y] = true;

        boolean valid = grid1[x][y] == 1;
        boolean up = dfs(grid1, grid2, x + 1, y, visited);
        boolean down = dfs(grid1, grid2, x - 1, y, visited);
        boolean right = dfs(grid1, grid2, x, y + 1, visited);
        boolean left = dfs(grid1, grid2, x, y - 1, visited);

        return up && down && left && right && valid;
    }
}

/* if need to do dfs on two grids simulaneously and checkwhter noth return the same, if they do, then count the island

first implement using only one grid

*/