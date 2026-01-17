class Solution {
    int m, n;
    int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxDistance(int[][] grid) {
        m = grid.length;
        int[][]dist = new int[m][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[] {i, j});
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = -1;
                }
            }
        }
        int max = -1;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < m && dist[nr][nc] == -1){
                    dist[nr][nc] = dist[r][c] + 1;
                    max = Math.max(max, dist[nr][nc]);
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return max;
    }
}