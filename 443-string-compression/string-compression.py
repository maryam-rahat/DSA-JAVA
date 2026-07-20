class Solution:
    def compress(self, chars: List[str]) -> int:
        i =0
        index = 0

        while i < len(chars):
            curr = chars[i]
            count = 0
            while i < len(chars) and curr == chars[i]:
                count+=1
                i += 1
            chars[index] = curr
            index += 1

            if count > 1:
                for digit in str(count):
                    chars[index] = digit
                    index += 1

        return index
                