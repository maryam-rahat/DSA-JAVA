class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int val : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(val);
                subsets.add(subset);
            }
        }

        return subsets;
    }
}