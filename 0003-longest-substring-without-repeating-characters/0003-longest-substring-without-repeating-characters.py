class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        lastSeen = dict()
        left = 0
        answer = 0

        for right in range(len(s)):
            c = s[right]

            if c in lastSeen and lastSeen[c] >= left:
                left = lastSeen[c] + 1
            
            lastSeen[c] = right
            answer = max(answer, right - left + 1)

        return answer
        