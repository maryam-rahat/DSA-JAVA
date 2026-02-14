class Solution:
    def maxDepth(self, s: str) -> int:
        st = []
        count = 0
        maxi = 0

        for i in s:
            if i == '(':
                st.append(i)
                maxi = max(maxi,len(st))
            if i == ')':
                st.pop()
        
        return maxi

        