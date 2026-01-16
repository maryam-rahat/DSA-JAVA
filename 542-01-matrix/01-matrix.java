class Solution {
    int m, n;
    int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for(int [] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nc >= 0 && nr >= 0 && nr < m && nc < n && !visited[nr][nc]){
                    dist[nr][nc] = dist[r][c] + 1;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}