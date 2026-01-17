class Solution {
    int m, n;
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;

        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    height[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && height[nr][nc] == -1) {
                    height[nr][nc] = height[r][c] + 1;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
        return height;
    }
}