class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mpp = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();

        for(int num: nums2){
            while(!q.isEmpty() && num > q.peek()){
                mpp.put(q.pop(), num);
            }
            q.push(num);
        }

        while(!q.isEmpty()){
            mpp.put(q.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = mpp.get(nums1[i]);
        }
        return res;
    }
}