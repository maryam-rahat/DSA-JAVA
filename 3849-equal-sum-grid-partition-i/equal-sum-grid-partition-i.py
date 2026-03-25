class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])

        total = sum(sum(row) for row in grid)

        if total % 2 != 0:
            return False

        target = total // 2

        prefix = 0
        for i in range(m-1):
            prefix += sum(grid[i])
            if prefix == target: return True

        prefix = 0
        for j in range(n-1):
            cols = sum(grid[i][j] for i in range(m))
            prefix += cols
            if prefix == target: return True

        return False

        