class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        result = []
        cur = []

        def backtrack(start, remaining: int):
            if remaining == 0:
                result.append(cur[:])
                return
            
            if remaining < 0:
                return
            
            for i in range(start, len(candidates)):
                cur.append(candidates[i])
                backtrack(i, remaining - candidates[i])
                cur.pop()
        
        backtrack(0, target)

        return result
        