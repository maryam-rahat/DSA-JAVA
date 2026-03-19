class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
    
        px = [[0]*n for _ in range(m)]
        py = [[0]*n for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                x = 1 if grid[i][j] == 'X' else 0
                y = 1 if grid[i][j] == 'Y' else 0
                
                px[i][j] = x
                py[i][j] = y
                
                if i > 0:
                    px[i][j] += px[i-1][j]
                    py[i][j] += py[i-1][j]
                if j > 0:
                    px[i][j] += px[i][j-1]
                    py[i][j] += py[i][j-1]
                if i > 0 and j > 0:
                    px[i][j] -= px[i-1][j-1]
                    py[i][j] -= py[i-1][j-1]
        
        count = 0
        
        for i in range(m):
            for j in range(n):
                x_count = px[i][j]
                y_count = py[i][j]
                
                if x_count == y_count and x_count > 0:
                    count += 1
        
        return count
        