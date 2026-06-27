class Solution:
    def countBits(self, n: int) -> List[int]:
        arr = [0] * (n+1)
        def bits(n):
            count = 0
            while n:
                n = n&(n-1)
                count+=1
            return count
            
        for i in range(len(arr)):
            arr[i] = bits(i)
        
        return arr

        
        