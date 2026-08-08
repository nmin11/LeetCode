from collections import Counter

class Solution:
    def longestPalindrome(self, s: str) -> int:
        counts = Counter(s)
        length = 0
        hasOdd = False

        for count in counts.values():
            length += (count // 2) * 2

            if count % 2 is 1:
                hasOdd = True
        
        if hasOdd:
            length += 1
        
        return length
        