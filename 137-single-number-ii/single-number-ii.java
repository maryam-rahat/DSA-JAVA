class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (mp.containsKey(num))
                mp.put(num, mp.get(num) + 1);
            else
                mp.put(num, 1);
        }
        for (int key : mp.keySet()) {
            if (mp.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}