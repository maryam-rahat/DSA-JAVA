class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] net = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            net[i] = gas[i] - cost[i];
            sum += net[i];
        }
        if (sum < 0)
            return -1;

        int tank = 0, start = 0;

        for (int i = 0; i < n; i++) {
            tank += net[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}