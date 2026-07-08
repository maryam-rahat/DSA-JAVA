class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0: return 0
        rows, cols = len(grid), len(grid[0])
        island = 0

        def bfs(r, c):
            q = deque()
            q.append((r,c))
            grid[r][c] = '0'

            dirs = [(0,1), (0,-1), (1,0), (-1,0)]

            while q:
                curr_r, curr_c = q.popleft()

                for dr, dc in dirs:
                    nc = curr_c + dc
                    nr = curr_r + dr

                    if (0<= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc]== '1'):
                        grid[nr][nc] = '0'
                        q.append((nr, nc))



        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    bfs(r, c)
                    island += 1

        return island