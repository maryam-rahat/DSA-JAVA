class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i < m && j < n){
            if(nums1[i]<nums2[j]){
                i++;
            } else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                set1.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            result[index++] = num;
        }

        return result;
    }
}