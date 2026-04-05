class Solution:
    def judgeCircle(self, moves: str) -> bool:
        horizon, vertical = [0, 0]

        for m in moves:
            if m == 'U': vertical +=1
            elif m == 'D': vertical -= 1
            elif m == 'R': horizon += 1
            else: horizon -= 1

        return horizon == 0 and vertical == 0
        