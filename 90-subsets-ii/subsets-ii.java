class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = 0;

            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }

            end = subsets.size() - 1;
            int size = subsets.size();

            for (int j = start; j < size; j++) {
                List<Integer> subset = new ArrayList<>(subsets.get(j));
                subset.add(nums[i]);
                subsets.add(subset);
            }
        }

        return subsets;
    }
}