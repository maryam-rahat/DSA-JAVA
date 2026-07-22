class Solution:
    def sortVowels(self, s: str) -> str:
        vowel_string = 'AEIOUaeiou'
        vowel_list = []
        res = ''
        for ch in s:
            if ch in vowel_string:
                vowel_list.append(ch)
            
        new_list = sorted(vowel_list)
        i = 0
        for ch in s:
            if ch in vowel_string and i < len(new_list):
                res += new_list[i]
                i+=1
            else:
                res += ch

        return res        

