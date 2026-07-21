class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = ['a','e', 'i', 'o', 'u', 'A', 'E','I', 'O', 'U']
        v1count = 0
        v2count = 0
        for i in range(len(s) // 2):
            if s[i] in vowels: v1count +=1

        for i in range(len(s)//2, len(s)):
            if s[i] in vowels: v2count +=1

        return v2count == v1count