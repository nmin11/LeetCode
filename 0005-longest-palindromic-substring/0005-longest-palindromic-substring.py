class Solution:
    def __init__(self):
        self.left = 0
        self.max_len = 0

    def extend_palindrome(self, s: str, j: int, k: int):
        l, r = j, k

        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        
        if self.max_len < r - l - 1:
            self.left = l + 1
            self.max_len = r - l - 1

    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2:
            return s
        
        for i in range(len(s) - 1):
            self.extend_palindrome(s, i, i + 1)
            self.extend_palindrome(s, i, i + 2)
        
        return s[self.left:self.left + self.max_len]
        