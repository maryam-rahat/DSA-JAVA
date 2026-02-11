class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        st = []
        arr = []
        for i in s:
            if i == '(' and not bool(st):
                st.append(i)

            elif i == ')' and len(st) == 1:
                st.pop()

            elif i == '(' and bool(st):
                st.append(i)
                arr.append(i)
            elif i == ')' and bool(st):
                st.pop()
                arr.append(i)

        return "".join(arr)
        


        