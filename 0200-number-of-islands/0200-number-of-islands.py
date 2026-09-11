class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        count = 0

        def sink(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return
            if grid[r][c] == '0':
                return
            
            grid[r][c] = '0'
            sink(r - 1, c)
            sink(r + 1, c)
            sink(r, c - 1)
            sink(r, c + 1)
        
        for r in range(0, rows):
            for c in range(0, cols):
                if grid[r][c] == '1':
                    count += 1
                    sink(r, c)
        
        return count
        