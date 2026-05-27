class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        state = [-1] * 26
        for char in word:
            idx = ord(char.lower()) - 97
            if char.islower():
                if state[idx] == -1: 
                    state[idx] = 0
                elif state[idx] == 1: 
                    state[idx] = 2
            else:
                if state[idx] == 0: 
                    state[idx] = 1
                elif state[idx] == -1: 
                    state[idx] = 2
        return state.count(1)