class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long total = nums[0];
        k--;
        
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        
        long leftSum = 0;
        int leftSize = 0;
        
        for (int i = 1; i <= dist + 1; i++) {
            right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
        }
        
        while (leftSize < k && !right.isEmpty()) {
            int num = right.firstKey();
            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSum += num;
            leftSize++;
            
            if (right.get(num) == 1) {
                right.remove(num);
            } else {
                right.put(num, right.get(num) - 1);
            }
        }
        
        long result = total + leftSum;
        
        for (int i = 1; i + dist + 1 < n; i++) {
            int removeNum = nums[i];
            int addNum = nums[i + dist + 1];
            
            if (left.containsKey(removeNum)) {
                if (left.get(removeNum) == 1) {
                    left.remove(removeNum);
                } else {
                    left.put(removeNum, left.get(removeNum) - 1);
                }
                leftSum -= removeNum;
                leftSize--;
                
                if (!right.isEmpty()) {
                    int num = right.firstKey();
                    left.put(num, left.getOrDefault(num, 0) + 1);
                    leftSum += num;
                    leftSize++;
                    
                    if (right.get(num) == 1) {
                        right.remove(num);
                    } else {
                        right.put(num, right.get(num) - 1);
                    }
                }
            } else if (right.containsKey(removeNum)) {
                if (right.get(removeNum) == 1) {
                    right.remove(removeNum);
                } else {
                    right.put(removeNum, right.get(removeNum) - 1);
                }
            }
            
            if (leftSize < k) {
                left.put(addNum, left.getOrDefault(addNum, 0) + 1);
                leftSum += addNum;
                leftSize++;
            } else if (addNum < left.lastKey()) {
                int lastKey = left.lastKey();
                left.put(addNum, left.getOrDefault(addNum, 0) + 1);
                leftSum += addNum;
                
                if (left.get(lastKey) == 1) {
                    left.remove(lastKey);
                } else {
                    left.put(lastKey, left.get(lastKey) - 1);
                }
                leftSum -= lastKey;
                right.put(lastKey, right.getOrDefault(lastKey, 0) + 1);
            } else {
                right.put(addNum, right.getOrDefault(addNum, 0) + 1);
            }
            
            if (leftSize == k) {
                result = Math.min(result, total + leftSum);
            }
        }
        
        return result;
    }
}