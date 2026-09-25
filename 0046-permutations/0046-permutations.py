class Solution:
    def permute(self, nums: list[int]) -> list[list[int]]:
        result = []
        cur = []
        used = [False] * len(nums)

        def backtrack():
            if len(cur) == len(nums):
                result.append(cur[:])
                return
            
            for i in range(len(nums)):
                if used[i]:
                    continue
                
                cur.append(nums[i])
                used[i] = True
                backtrack()
                cur.pop()
                used[i] = False

        backtrack()

        return result
        