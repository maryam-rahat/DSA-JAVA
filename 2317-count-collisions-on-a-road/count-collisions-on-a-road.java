class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();

        int start = 0;
        while (start < n && directions.charAt(start) == 'L') {
            start++;
        }
        
        if (start == n) {
            return 0;
        }

        int end = n - 1;
        while (end >= start && directions.charAt(end) == 'R') {
            end--;
        }

        int collisions = 0;
        for (int i = start; i <= end; i++) {
            char dir = directions.charAt(i);
            if (dir == 'L' || dir == 'R') {
                collisions++;
            }
        }
        
        return collisions;
    }
}