class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = defaultdict(int)
        i = 0
        res = 0

        for j in range(len(s)):
            freq[s[j]] += 1

            while (j - i + 1) - max(freq.values()) > k:
                freq[s[i]] -= 1
                i+=1
            res = max(res, j - i + 1)

        return res
            
                


