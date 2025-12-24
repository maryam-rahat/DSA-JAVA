class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApple = 0;
        int totalCapacity = 0;

        for (int a : apple) {
            totalApple += a;
        }

        Arrays.sort(capacity);

        for (int i = capacity.length - 1, count = 0; i >= 0; i--) {
            totalCapacity += capacity[i];
            count++;
            if (totalCapacity >= totalApple) {
                return count;
            }
        }

        return capacity.length;
    }
}
