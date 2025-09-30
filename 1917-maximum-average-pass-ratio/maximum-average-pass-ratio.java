class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((classA, classB) -> {
            double gainA = (classA[0] + 1) / (classA[1] + 1) - classA[0] / classA[1];
            double gainB = (classB[0] + 1) / (classB[1] + 1) - classB[0] / classB[1];
            return Double.compare(gainB, gainA);
        });

        for (int[] classInfo : classes) {
            maxHeap.offer(new double[] {classInfo[0], classInfo[1]});
        }
      
        while (extraStudents-- > 0) {
            double[] topClass = maxHeap.poll();
            double newPassCount = topClass[0] + 1;
            double newTotalCount = topClass[1] + 1;
            maxHeap.offer(new double[] {newPassCount, newTotalCount});
        }
      
        double totalRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] classInfo = maxHeap.poll();
            totalRatio += classInfo[0] / classInfo[1];
        }
      
        return totalRatio / classes.length;
    }
}