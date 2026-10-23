class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "" or len(s) < len(t):
            return ""
        
        need = Counter(t)
        required = len(need)
        window = {}
        have = 0
        left = 0
        best_len = float('inf')
        best_start = 0

        for right in range(0, len(s)):
            c = s[right]
            window[c] = window.get(c, 0) + 1

            if c in need and window[c] == need[c]:
                have += 1
            
            while have == required:
                cur_len = right - left + 1

                if cur_len < best_len:
                    best_len = cur_len
                    best_start = left
                
                left_char = s[left]

                if left_char in need and window[left_char] == need[left_char]:
                    have -= 1

                window[left_char] -= 1
                left += 1
        
        if best_len == float('inf'):
            return ""
        
        return s[best_start : best_start + best_len]
        