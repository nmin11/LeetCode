class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []
        cur = []

        def backtrack(start):
            result.append(cur[:])

            for i in range(start, len(nums)):
                cur.append(nums[i])
                backtrack(i + 1)
                cur.pop()
        
        backtrack(0)

        return result
        