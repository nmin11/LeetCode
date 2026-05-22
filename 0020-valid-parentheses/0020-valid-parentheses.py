class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        pair = {')': '(', '}': '{', ']': '['}

        for c in s:
            if c in ('(', '{', '['):
                st.append(c)
            else:
                if not st or st[-1] != pair[c]:
                    return False
                st.pop()
    
        return not st
