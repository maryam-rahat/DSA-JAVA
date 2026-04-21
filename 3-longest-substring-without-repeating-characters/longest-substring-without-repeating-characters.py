class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i = 0
        mx = 0
        window_set = set()

        for j in range(len(s)):
            current = s[j]

            while current in window_set:
                window_set.remove(s[i])
                i += 1

            window_set.add(current)
            mx = max(mx, j - i + 1)

        return mx