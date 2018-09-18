class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;  // 當前掃到的元素以左的sum
        int sum = 0;
        for (int cur : nums) {
            sum += cur;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (sum - nums[i] - left == left) {
                return i;
            }
        }
        return -1;
    }
}