class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        origin_color = image[sr][sc]
        if origin_color == color:
            return image
        
        rows = len(image)
        cols = len(image[0])

        def dfs(r: int, c: int):
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return
            
            if image[r][c] != origin_color:
                return
            
            image[r][c] = color

            directions = [(0,1), (0,-1), (1,0), (-1,0)]
            for dr, dc in directions:
                dfs(r + dr, c + dc)

        dfs(sr, sc)

        return image
        