class Solution:
    def firstUniqChar(self, s: str) -> int:
        char_counts = Counter(s)

        for i, c in enumerate(s):
            if char_counts[c] == 1: return i

        return -1

        
        