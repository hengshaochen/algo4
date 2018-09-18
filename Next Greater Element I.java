// O(mn)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean find = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    find = true;
                }
                
                if (find == true) {
                    if (nums2[j] > nums1[i]) {
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}

// O(m + n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!s.isEmpty() && s.peek() < num) {
                map.put(s.peek(), num);
                s.pop();
            }
            s.push(num);
        }
        
        int[] ans = new int[nums1.length];
        int i = 0;
        for (int num : nums1) {
            if (map.containsKey(num)) {
                ans[i++] = map.get(num);
            } else {
                ans[i++] = -1;
            }
        }
        return ans;
    }
}