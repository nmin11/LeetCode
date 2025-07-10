from collections import Counter
import re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = re.sub(r'\W+', ' ', paragraph).lower().split()
        counts = Counter(w for w in words if w not in set(banned))
        return counts.most_common(1)[0][0]
        