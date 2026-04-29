class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        i = 0
        freq = defaultdict(int)
        sstrings = 0

        for j in range(len(s)):
            current = s[j]
            freq[current] +=1

            while len(freq) == 3:
                sstrings += len(s) - j
                freq[s[i]] -= 1
                if freq[s[i]] == 0:
                    del freq[s[i]]
                i+=1
        
        return sstrings