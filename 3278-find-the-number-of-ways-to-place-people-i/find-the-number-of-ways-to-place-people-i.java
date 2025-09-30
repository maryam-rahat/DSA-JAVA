class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
      
        int pairCount = 0;
        int n = points.length;
        final int NEGATIVE_INFINITY = 1 << 30; 
        for (int i = 0; i < n; ++i) {
            int leftPointY = points[i][1];
            int maxYSeen = -NEGATIVE_INFINITY;  
            for (int j = i + 1; j < n; ++j) {
                int rightPointY = points[j][1];
              
                if (maxYSeen < rightPointY && rightPointY <= leftPointY) {
                    maxYSeen = rightPointY;  
                    ++pairCount;  
                }
            }
        }
      
        return pairCount;
    }
}