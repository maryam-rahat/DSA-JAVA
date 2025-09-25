class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) return 0;

        for(int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i+1);

            for(int j = 0; j < currentRow.size(); j++){
                int sum1 = nextRow.get(j);
                int sum2 = nextRow.get(j + 1);

                int newSum = currentRow.get(j) + Math.min(sum1, sum2);
                currentRow.set(j, newSum);
            }
        }
        return triangle.get(0).get(0);
    }
}