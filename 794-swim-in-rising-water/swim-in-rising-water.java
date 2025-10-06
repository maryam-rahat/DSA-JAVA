class Solution {
    private int[] parent;

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        parent = new int[n * n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int[] heightToIndex = new int[n * n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int height = grid[row][col];
                int flattenedIndex = row * n + col;
                heightToIndex[height] = flattenedIndex;
            }
        }

        int[] directions = {-1, 0, 1, 0, -1};

        for (int time = 0; time < n * n; time++) {
            int currentIndex = heightToIndex[time];
            int currentRow = currentIndex / n;
            int currentCol = currentIndex % n;

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = currentRow + directions[dir];
                int nextCol = currentCol + directions[dir + 1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n 
                    && grid[nextRow][nextCol] <= time) {
                    int nextIndex = nextRow * n + nextCol;
                    parent[find(nextIndex)] = find(currentIndex);
                }

                if (find(0) == find(n * n - 1)) {
                    return time;
                }
            }
        }

        return -1;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
