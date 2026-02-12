class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        lcp = os.path.commonprefix(strs)
        return lcp
