class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        total_sum = sum(cardPoints)
        n = len(cardPoints)
        
        window_size = n - k
        window_sum = sum(cardPoints[:window_size])
        
        max_score = total_sum - window_sum
        
        for i in range(window_size, n):
            window_sum += cardPoints[i] - cardPoints[i - window_size]
            max_score = max(max_score, total_sum - window_sum)
        
        return max_score